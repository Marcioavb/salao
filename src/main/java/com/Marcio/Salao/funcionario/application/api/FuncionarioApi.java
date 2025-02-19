package com.Marcio.Salao.funcionario.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/funcionario")
@Tag(name = "Funcionario", description = "Endpoints relacionados ao gerenciamento de funcionarios.")
public interface FuncionarioApi {

    @PostMapping
    @Operation(
            summary = "Cadastra um novo cliente",
            description = "Este endpoint cadastra um novo cliente no sistema, permitindo o " +
                    "acesso a serviços e funcionalidades relacionadas ao cliente."
    )   @ResponseStatus(HttpStatus.CREATED)
        FuncionarioResponse cadastraFuncionarios(@RequestBody FuncionarioRequest funcionarioRequest);

    @GetMapping(value = "/{idFuncionario}")
    @Operation(summary = "Retorna um funcionario por ID",
            description = "Este endpoint recupera os detalhes de um funcionario específico com base no ID fornecido.")
    @ResponseStatus(code = HttpStatus.OK)
    FuncionarioDetalhadoResponse buscafuncionarioPorId(@PathVariable UUID idFuncionario);

}
