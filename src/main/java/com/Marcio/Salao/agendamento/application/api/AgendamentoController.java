//package com.Marcio.Salao.agendamento.application.api;
//
//import com.Marcio.Salao.agendamento.application.service.AgendamentoService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//@Log4j2
//public class AgendamentoController implements AgendamentoApi {
//
//    private final AgendamentoService agendamentoService;
//
//    @Override
//    public AgendamentoResponse realizarAgendamento(AgendamentoRequest agendamentoRequest) {
//        log.info("[inicia] AgendamentoController - realizarAgendamento");
//        AgendamentoResponse agendamentoRealizado = agendamentoService.realizaAgendamento(agendamentoRequest);
//        log.info("[finaliza] AgendamentoController - realizarAgendamento");
//        return agendamentoRealizado;
//    }
//}
