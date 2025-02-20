package com.Marcio.Salao.agendamento.application.repository;

import com.Marcio.Salao.agendamento.domain.Agendamento;

import java.time.LocalDateTime;
import java.util.UUID;

public interface AgendamentoRepository {
    void salva(Agendamento agendamento);
    boolean existeAgendamentoParaFuncionarioNaData(UUID idFuncionario, LocalDateTime dataHora);
}
