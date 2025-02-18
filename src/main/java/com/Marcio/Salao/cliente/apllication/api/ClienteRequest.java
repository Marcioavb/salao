package com.Marcio.Salao.cliente.apllication.api;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@ToString
@Getter
public class ClienteRequest {
    @NotBlank(message = "Nome completo é obrigatório")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    private String nomeCompleto;

    @NotBlank(message = "Telefone é obrigatório")
    @Pattern(regexp = "^\\(?\\d{2}\\)?[\\s-]?\\d{4,5}-?\\d{4}$",
            message = "Telefone inválido. Use o formato (XX) XXXX-XXXX ou (XX) XXXXX-XXXX")
    private String telefone;
}
