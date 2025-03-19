package com.Marcio.Salao.servico.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/servico")
@Tag(name = "Servico", description = "Endpoints relacionados ao gerenciamento de serviços.")
public interface ServicoApi {

    @PostMapping
    @Operation(summary = "Cadastra um novo serviço")
    @ResponseStatus(HttpStatus.CREATED)
    ServicoResponse cadastraServico(@RequestBody ServicoRequest servicoRequest);

    @GetMapping(value = "/{idServico}")
    @Operation(summary = "Busca um serviço por ID")
    @ResponseStatus(HttpStatus.OK)
    ServicoDetalhadoResponse buscaServicoPorId(@PathVariable UUID idServico);

    @GetMapping
    @Operation(summary = "Lista todos os serviços paginados")
    @ResponseStatus(HttpStatus.OK)
    Page<ServicoDetalhadoResponse> listaTodosServicos(Pageable pageable);
}
