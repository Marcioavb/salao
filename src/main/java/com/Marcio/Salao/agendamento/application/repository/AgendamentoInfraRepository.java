package com.Marcio.Salao.agendamento.application.repository;

import com.Marcio.Salao.agendamento.domain.Agendamento;
import com.Marcio.Salao.agendamento.infra.AgendamentoSpringDataJPARepository;
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
}