package com.Marcio.Salao.cliente.apllication.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/cliente")
@Tag(name = "Cliente", description = "Endpoints relacionados ao gerenciamento de clientes.")
public interface ClienteAPI {

    @PostMapping
    @Operation(
            summary = "Cadastra um novo cliente",
            description = "Este endpoint cadastra um novo cliente no sistema, permitindo o " +
                    "acesso a serviços e funcionalidades relacionadas ao cliente."
    )    @ResponseStatus(HttpStatus.CREATED)
    ClienteResponse cadastraCliente(@RequestBody ClienteRequest clienteRequest);

    @GetMapping(value = "/{idCliente}")
    @Operation(summary = "Retorna um cliente por ID",
            description = "Este endpoint recupera os detalhes de um cliente específico com base no ID fornecido.")
    @ResponseStatus(code = HttpStatus.OK)
    ClienteDetalhadoResponse buscaClientePorId(@PathVariable UUID idCliente);

}
