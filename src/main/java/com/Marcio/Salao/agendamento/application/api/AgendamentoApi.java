package com.Marcio.Salao.agendamento.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@Tag(name = "Agendamento", description = "Endpoints para agendar e gerenciar horários.")
@RequestMapping("/agendamento")
public interface AgendamentoApi {

    @PostMapping
    @Operation(summary = "Cria um novo agendamento")
    @ResponseStatus(HttpStatus.CREATED)
    AgendamentoDetalhadoResponse criaAgendamento(@RequestBody AgendamentoRequest agendamentoRequest);

//    @GetMapping("/{idAgendamento}")
//    @Operation(summary = "Busca agendamento por ID")
//    @ResponseStatus(HttpStatus.OK)
//    AgendamentoDetalhadoResponse buscaAgendamentoPorId(@PathVariable UUID idAgendamento);

//    @GetMapping("/funcionario/{idFuncionario}")
//    @Operation(summary = "Lista agendamentos por funcionário")
//    @ResponseStatus(HttpStatus.OK)
//    Page<AgendamentoDetalhadoResponse> listaAgendamentosPorFuncionario
//            (@PathVariable UUID idFuncionario, Pageable pageable);

//    @PatchMapping("/{idAgendamento}/cancelar")
//    @Operation(summary = "Cancela um agendamento")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    void cancelaAgendamento(@PathVariable UUID idAgendamento);
}