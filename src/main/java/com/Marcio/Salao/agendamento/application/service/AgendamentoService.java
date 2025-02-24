package com.Marcio.Salao.agendamento.application.service;

import com.Marcio.Salao.agendamento.application.api.AgendamentoDetalhadoResponse;
import com.Marcio.Salao.agendamento.application.api.AgendamentoRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface AgendamentoService {
    AgendamentoDetalhadoResponse criaAgendamento(AgendamentoRequest agendamentoRequest);
    AgendamentoDetalhadoResponse buscaAgendamentoPorId(UUID idAgendamento);
    Page<AgendamentoDetalhadoResponse> listaAgendamentosPorFuncionario(UUID idFuncionario, Pageable pageable);
    void cancelaAgendamento(UUID idAgendamento);
}
