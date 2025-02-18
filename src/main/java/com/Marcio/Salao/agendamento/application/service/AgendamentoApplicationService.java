//package com.Marcio.Salao.agendamento.application.service;
//
//import com.Marcio.Salao.agendamento.application.api.AgendamentoRequest;
//import com.Marcio.Salao.agendamento.application.api.AgendamentoResponse;
//import com.Marcio.Salao.agendamento.application.repository.AgendamentoRepository;
//import com.Marcio.Salao.agendamento.domain.Agendamento;
//import com.Marcio.Salao.cliente.apllication.repository.ClienteRepository;
//import com.Marcio.Salao.handler.APIException;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//
//@Service
//@RequiredArgsConstructor
//@Log4j2
//public class AgendamentoApplicationService implements AgendamentoService {
//    private final AgendamentoRepository agendamentoRepository;
//    private final ClienteRepository clienteRepository;
//
//    @Override
//    public AgendamentoResponse realizaAgendamento(AgendamentoRequest agendamentoRequest) {
//        log.info("[inicia] AgendamentoApplicationService - realizaAgendamento");
//
//        var cliente = clienteRepository.findById(agendamentoRequest.getIdCliente())
//                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
//
//
////        // Valida horário
////        var horario = horarioDisponivelRepository.findById(agendamentoRequest.getIdHorario())
////                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Horário não encontrado"));
//
//        // Verifica se o horário já está ocupado
//        if (agendamentoRepository.existsByHorario(horario)) {
//            throw APIException.build(HttpStatus.BAD_REQUEST, "Horário já ocupado para agendamento");
//        }
//
//        // Cria o agendamento
//        Agendamento agendamento = Agendamento.builder()
//                .cliente(cliente)
//                .dataAgendamento(LocalDateTime.now())
//                .build();
//
//        agendamentoRepository.save(agendamento);
//        log.info("[finaliza] AgendamentoApplicationService - realizaAgendamento");
//        return new AgendamentoResponse(agendamento);
//    }
//}
