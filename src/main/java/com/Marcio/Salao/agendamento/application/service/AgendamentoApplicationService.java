package com.Marcio.Salao.agendamento.application.service;

import com.Marcio.Salao.agendamento.application.api.AgendamentoDetalhadoResponse;
import com.Marcio.Salao.agendamento.application.api.AgendamentoRequest;
import com.Marcio.Salao.agendamento.application.repository.AgendamentoRepository;
import com.Marcio.Salao.agendamento.domain.Agendamento;
import com.Marcio.Salao.agendamento.domain.StatusAgendamento;
import com.Marcio.Salao.cliente.apllication.repository.ClienteRepository;
import com.Marcio.Salao.funcionario.application.repository.FuncionarioRepository;
import com.Marcio.Salao.funcionario.domain.Funcionario;
import com.Marcio.Salao.handler.APIException;
import com.Marcio.Salao.salao.domain.Salao;
import com.Marcio.Salao.servico.application.repository.ServicoRepository;
import com.Marcio.Salao.servico.domain.Servico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class AgendamentoApplicationService implements AgendamentoService {
    private final AgendamentoRepository agendamentoRepository;
    private final ClienteRepository clienteRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final ServicoRepository servicoRepository;

    @Override
    public AgendamentoDetalhadoResponse criaAgendamento(AgendamentoRequest request) {
        log.info("[inicia] AgendamentoApplicationService - criaAgendamento");

        validaDataHoraFutura(request.getDataHora());
        var cliente = clienteRepository.buscaPorId(request.getIdCliente());
        var funcionario = funcionarioRepository.buscaFuncionarioID(request.getIdFuncionario());
        var servico = servicoRepository.buscaServicoPoId(request.getIdServico());

        // Validações adicionais:
        validaMesmoSalao(funcionario, servico);
        validaHorarioFuncionamento(funcionario.getSalao(), request.getDataHora());

        validaConflitoHorario(funcionario.getIdFuncionario(), request.getDataHora(), servico.getDuracao());

        var agendamento = new Agendamento(cliente, funcionario, servico, funcionario.getSalao(), request.getDataHora());
        agendamentoRepository.salva(agendamento);

        log.info("[finaliza] AgendamentoApplicationService - criaAgendamento");
        return new AgendamentoDetalhadoResponse(agendamento);
    }

    // Métodos de validação (adicione dentro da classe):
    private void validaMesmoSalao(Funcionario funcionario, Servico servico) {
        if (!funcionario.getSalao().getIdSalao().equals(servico.getSalao().getIdSalao())) {
            throw APIException.build(HttpStatus.BAD_REQUEST,
                    "Funcionário e serviço devem pertencer ao mesmo salão!");
        }
    }

    private void validaHorarioFuncionamento(Salao salao, LocalDateTime dataHora) {
        LocalTime horaAgendamento = dataHora.toLocalTime();

        if (horaAgendamento.isBefore(salao.getHorarioAbertura())
                || horaAgendamento.isAfter(salao.getHorarioFechamento())) {
            throw APIException.build(HttpStatus.BAD_REQUEST,
                    "Agendamento fora do horário de funcionamento do salão!");
        }
    }

    @Override
    public AgendamentoDetalhadoResponse buscaAgendamentoPorId(UUID idAgendamento) {
        log.info("[inicia] AgendamentoApplicationService - buscaAgendamentoPorId");

        Agendamento agendamento = agendamentoRepository.buscaPorId(idAgendamento)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Agendamento não encontrado!"));
        verificaEAtualizaStatus(agendamento); // <--- Verificação automática

        log.info("[finaliza] AgendamentoApplicationService - buscaAgendamentoPorId");
        return new AgendamentoDetalhadoResponse(agendamento);
    }

    @Override
    public Page<AgendamentoDetalhadoResponse> listaAgendamentosPorFuncionario(UUID idFuncionario, Pageable pageable) {
        log.info("[inicia] AgendamentoApplicationService - listaAgendamentosPorFuncionario");

        Page<Agendamento> agendamentos = agendamentoRepository.buscaPorFuncionario(idFuncionario, pageable);
        agendamentos.forEach(this::verificaEAtualizaStatus); // <--- Verificação automática

        log.info("[finaliza] AgendamentoApplicationService - listaAgendamentosPorFuncionario");
        return agendamentos.map(AgendamentoDetalhadoResponse::new);

    }

    @Override
    public void cancelaAgendamento(UUID idAgendamento) {
        log.info("[inicia] AgendamentoApplicationService - cancelaAgendamento");
        Agendamento agendamento = agendamentoRepository.buscaPorId(idAgendamento)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Agendamento não encontrado!"));

        if (agendamento.getStatus() == StatusAgendamento.CANCELADO) {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Agendamento já está cancelado!");
        }

        if (agendamento.getDataHora().isBefore(LocalDateTime.now())) {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Não é possível cancelar agendamentos passados!");
        }

        agendamento.setStatus(StatusAgendamento.CANCELADO);
        agendamentoRepository.salva(agendamento);
        log.info("[finaliza] AgendamentoApplicationService - cancelaAgendamento");
    }

    private void validaDataHoraFutura(LocalDateTime dataHora) {
        if (dataHora.isBefore(LocalDateTime.now())) {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Agendamento deve ser para um horário futuro!");
        }
    }

    private void validaConflitoHorario(UUID idFuncionario, LocalDateTime dataHora, Integer duracaoServico) {
        // Busca o funcionário para obter o salão
        Funcionario funcionario = funcionarioRepository.buscaFuncionarioID(idFuncionario);
        UUID idSalao = funcionario.getSalao().getIdSalao();

        boolean conflito = agendamentoRepository.existeConflitoAgendamento(
                idFuncionario,
                idSalao,
                dataHora,
                duracaoServico
        );

        if (conflito) {
            throw APIException.build(HttpStatus.CONFLICT, "Conflito de horário! O funcionário já possui um agendamento nesse período.");
        }
    }

    private void verificaEAtualizaStatus(Agendamento agendamento) {
        LocalDateTime agora = LocalDateTime.now(); // Pega a hora atual do sistema
        LocalDateTime termino = agendamento.getDataHoraTermino(); // Hora de término do serviço

        if (agora.isAfter(termino) && agendamento.getStatus() == StatusAgendamento.CONFIRMADO) {
            agendamento.setStatus(StatusAgendamento.FINALIZADO);
            agendamentoRepository.salva(agendamento); // Salvar a alteração no banco
            log.info("Agendamento {} atualizado para FINALIZADO", agendamento.getIdAgendamento());
        }
    }
}
