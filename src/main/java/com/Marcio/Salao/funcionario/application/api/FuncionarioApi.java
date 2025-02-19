package com.Marcio.Salao.funcionario.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

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
}
