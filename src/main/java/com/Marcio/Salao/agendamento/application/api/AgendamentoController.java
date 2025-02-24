package com.Marcio.Salao.agendamento.application.api;

import com.Marcio.Salao.agendamento.application.service.AgendamentoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
public class AgendamentoController implements AgendamentoApi {

    private final AgendamentoService agendamentoService;

    @Override
    public AgendamentoDetalhadoResponse criaAgendamento(AgendamentoRequest agendamentoRequest) {
        log.info("[inicia] AgendamentoController - realizarAgendamento");
        AgendamentoDetalhadoResponse agendamentoCriado = agendamentoService.criaAgendamento(agendamentoRequest);
        log.info("[finaliza] AgendamentoController - realizarAgendamento");
        return agendamentoCriado;
    }
    @Override
    public AgendamentoDetalhadoResponse buscaAgendamentoPorId(UUID idAgendamento) {
        log.info("[inicia] AgendamentoController - buscaAgendamentoPorId");
        AgendamentoDetalhadoResponse response = agendamentoService.buscaAgendamentoPorId(idAgendamento);
        log.info("[finaliza] AgendamentoController - buscaAgendamentoPorId");
        return response;
    }

    @Override
    public Page<AgendamentoDetalhadoResponse> listaAgendamentosPorFuncionario(UUID idFuncionario, Pageable pageable) {
        log.info("[inicia] AgendamentoController - listaAgendamentosPorFuncionario");
        Page<AgendamentoDetalhadoResponse> response = agendamentoService.listaAgendamentosPorFuncionario(idFuncionario, pageable);
        log.info("[finaliza] AgendamentoController - listaAgendamentosPorFuncionario");
        return response;
    }

    @Override
    public void cancelaAgendamento(UUID idAgendamento) {
        log.info("[inicia] AgendamentoController - cancelaAgendamento");
        agendamentoService.cancelaAgendamento(idAgendamento);
        log.info("[finaliza] AgendamentoController - cancelaAgendamento");
    }
}
