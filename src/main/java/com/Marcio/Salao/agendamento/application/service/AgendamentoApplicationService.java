package com.Marcio.Salao.agendamento.application.service;

import com.Marcio.Salao.agendamento.application.api.AgendamentoDetalhadoResponse;
import com.Marcio.Salao.agendamento.application.api.AgendamentoRequest;
import com.Marcio.Salao.agendamento.application.repository.AgendamentoRepository;
import com.Marcio.Salao.agendamento.domain.Agendamento;
import com.Marcio.Salao.cliente.apllication.repository.ClienteRepository;
import com.Marcio.Salao.funcionario.application.repository.FuncionarioRepository;
import com.Marcio.Salao.handler.APIException;
import com.Marcio.Salao.servico.application.repository.ServicoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public AgendamentoDetalhadoResponse criaAgendamento(AgendamentoRequest agendamentoRequest) {
        log.info("[inicia] AgendamentoApplicationService - criaAgendamento");

        // Validações
        validaDataHoraFutura(agendamentoRequest.getDataHora());
        var cliente = clienteRepository.buscaPorId(agendamentoRequest.getIdCliente());
        var funcionario = funcionarioRepository.buscaFuncionarioID(agendamentoRequest.getIdFuncionario());
        var servico = servicoRepository.buscaServicoPoId(agendamentoRequest.getIdServico());
        validaConflitoHorario(funcionario.getIdFuncionario(), agendamentoRequest.getDataHora());

        // Criação
        var agendamento = new Agendamento(cliente, funcionario, servico, agendamentoRequest.getDataHora());
        agendamentoRepository.salva(agendamento);

        log.info("[finaliza] AgendamentoApplicationService - criaAgendamento");
        return new AgendamentoDetalhadoResponse(agendamento);
    }

    private void validaDataHoraFutura(LocalDateTime dataHora) {
        if (dataHora.isBefore(LocalDateTime.now())) {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Agendamento deve ser para um horário futuro!");
        }
    }

    private void validaConflitoHorario(UUID idFuncionario, LocalDateTime dataHora) {
        boolean existeConflito = agendamentoRepository.existeAgendamentoParaFuncionarioNaData(idFuncionario, dataHora);
        if (existeConflito) {
            throw APIException.build(HttpStatus.CONFLICT, "Já existe um agendamento para este funcionário no horário selecionado!");
        }
    }
}
