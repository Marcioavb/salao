package com.Marcio.Salao.agendamento.application.service;

import com.Marcio.Salao.agendamento.application.api.AgendamentoDetalhadoResponse;
import com.Marcio.Salao.agendamento.application.api.AgendamentoRequest;

public interface AgendamentoService {
    AgendamentoDetalhadoResponse criaAgendamento(AgendamentoRequest agendamentoRequest);
}
