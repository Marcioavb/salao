package com.Marcio.Salao.agendamento.infra;

import com.Marcio.Salao.agendamento.application.repository.AgendamentoRepository;
import com.Marcio.Salao.agendamento.domain.Agendamento;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
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

    public boolean existeConflitoAgendamento(UUID idFuncionario, LocalDateTime dataHora, Integer duracaoServico) {
        log.info("[inicia] AgendamentoInfraRepository - existeConflitoAgendamento");
        boolean existe = agendamentoSpringDataJPARepository.existsConflitoAgendamento(
                idFuncionario,
                dataHora,
                duracaoServico
        );
        log.info("[finaliza] AgendamentoInfraRepository - existeConflitoAgendamento");
        return existe;
    }

    @Override
    public Agendamento findAgendamentoConflitante(UUID idFuncionario, LocalDateTime dataHora, Integer duracaoServico) {
        log.info("[inicia] AgendamentoInfraRepository - findAgendamentoConflitante");
        Agendamento conflito = agendamentoSpringDataJPARepository.findConflitoAgendamento(
                idFuncionario,
                dataHora,
                duracaoServico
        );
        log.info("[finaliza] AgendamentoInfraRepository - findAgendamentoConflitante");
        return conflito;
    }
}