//package com.Marcio.Salao.agendamento.application.api;
//
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//@Tag(name = "Agendamento", description = "Endpoints relacionados ao agendamento de clientes.")
//@RequestMapping("/agendamento")
//public interface AgendamentoApi {
//
//    @PostMapping
//    @Operation(summary = "Realiza um agendamento", description = "Este endpoint realiza o agendamento para um " +
//            "cliente em um horário disponível.")
//    @ResponseStatus(HttpStatus.CREATED)
//    AgendamentoResponse realizarAgendamento(@RequestBody AgendamentoRequest agendamentoRequest);
//
//}
