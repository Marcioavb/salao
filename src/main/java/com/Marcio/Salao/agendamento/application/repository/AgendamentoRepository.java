package com.Marcio.Salao.agendamento.application.repository;

import com.Marcio.Salao.agendamento.domain.Agendamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public interface AgendamentoRepository {
    void salva(Agendamento agendamento);
    boolean existeAgendamentoParaFuncionarioNaData(UUID idFuncionario, LocalDateTime dataHora);
    Agendamento findAgendamentoConflitante(UUID idFuncionario, UUID idSalao,LocalDateTime dataHora, Integer duracaoServico);
    boolean existeConflitoAgendamento(UUID idFuncionario, UUID idSalao, LocalDateTime dataHora, Integer duracaoServico);
    Optional<Agendamento> buscaPorId(UUID idAgendamento);
    Page<Agendamento> buscaPorFuncionario(UUID idFuncionario, Pageable pageable);
}
