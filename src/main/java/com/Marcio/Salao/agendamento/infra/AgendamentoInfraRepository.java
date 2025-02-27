package com.Marcio.Salao.agendamento.infra;

import com.Marcio.Salao.agendamento.application.repository.AgendamentoRepository;
import com.Marcio.Salao.agendamento.domain.Agendamento;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Log4j2
public class AgendamentoInfraRepository implements AgendamentoRepository {

    private final AgendamentoSpringDataJPARepository agendamentoSpringDataJPARepository;

    @Override
    public void salva(Agendamento agendamento) {
        log.info("[inicia] AgendamentoInfraRepository - salva");
        agendamentoSpringDataJPARepository.save(agendamento);
        log.info("[finaliza] AgendamentoInfraRepository - salva");
    }

    @Override
    public boolean existeAgendamentoParaFuncionarioNaData(UUID idFuncionario, LocalDateTime dataHora) {
        log.info("[inicia] AgendamentoInfraRepository - existeAgendamentoParaFuncionarioNaData");
        boolean existe = agendamentoSpringDataJPARepository.existsByFuncionarioIdAndDataHora(idFuncionario, dataHora);
        log.info("[finaliza] AgendamentoInfraRepository - existeAgendamentoParaFuncionarioNaData");
        return existe;
    }

    public boolean existeConflitoAgendamento(UUID idFuncionario, UUID idSalao, LocalDateTime dataHora, Integer duracaoServico) {
        log.info("[inicia] AgendamentoInfraRepository - existeConflitoAgendamento");
        boolean existe = agendamentoSpringDataJPARepository.existsConflitoAgendamento(
                idFuncionario,
                idSalao, // Novo parâmetro
                dataHora,
                duracaoServico
        );
        log.info("[finaliza] AgendamentoInfraRepository - existeConflitoAgendamento");
        return existe;
    }

    @Override
    public Optional<Agendamento> buscaPorId(UUID idAgendamento) {
        log.info("[inicia] AgendamentoInfraRepository - buscaPorId");
        Optional<Agendamento> agendamento = agendamentoSpringDataJPARepository.findById(idAgendamento);
        log.info("[finaliza] AgendamentoInfraRepository - buscaPorId");
        return agendamento;
    }

    @Override
    public Page<Agendamento> buscaPorFuncionario(UUID idFuncionario, Pageable pageable) {
        log.info("[inicia] AgendamentoInfraRepository - buscaPorFuncionario");
        Page<Agendamento> agendamentos = agendamentoSpringDataJPARepository.findByFuncionarioIdFuncionario(idFuncionario, pageable);
        log.info("[finaliza] AgendamentoInfraRepository - buscaPorFuncionario");
        return agendamentos;
    }

    @Override
    public Agendamento findAgendamentoConflitante(UUID idFuncionario, UUID idSalao, LocalDateTime dataHora, Integer duracaoServico) {
        log.info("[inicia] AgendamentoInfraRepository - findAgendamentoConflitante");
        Agendamento conflito = agendamentoSpringDataJPARepository.findConflitoAgendamento(
                idFuncionario,
                idSalao,
                dataHora,
                duracaoServico
        );
        log.info("[finaliza] AgendamentoInfraRepository - findAgendamentoConflitante");
        return conflito;
    }
}