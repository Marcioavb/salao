package com.Marcio.Salao.cliente.apllication.api;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@ToString
@Getter
public class ClienteRequest {
    @NotBlank
    private String nomeCompleto;
    @NotBlank
    private String telefone;
}
