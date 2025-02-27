package com.Marcio.Salao.salao.application.api;

import com.Marcio.Salao.funcionario.application.api.FuncionarioDetalhadoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/salao")
@Tag(name = "Salao", description = "Endpoints para gerenciar salões.")
public interface SalaoApi {

    @PostMapping
    @Operation(summary = "Cadastra um novo salão")
    @ResponseStatus(HttpStatus.CREATED)
    SalaoResponse cadastraSalao(@RequestBody SalaoRequest salaoRequest);

    @GetMapping("/{idSalao}")
    @Operation(summary = "Busca salão por ID")
    @ResponseStatus(HttpStatus.OK)
    SalaoDetalhadoResponse buscaSalaoPorId(@PathVariable UUID idSalao);

    @GetMapping
    @Operation(summary = "Lista todos os salões")
    @ResponseStatus(HttpStatus.OK)
    Page<SalaoDetalhadoResponse> listaTodosSaloes(Pageable pageable);

}
