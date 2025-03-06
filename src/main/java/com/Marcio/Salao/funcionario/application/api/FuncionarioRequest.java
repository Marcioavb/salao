package com.Marcio.Salao.funcionario.application.api;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.UUID;

@ToString
@Getter
public class FuncionarioRequest {

    @NotBlank(message = "Nome do funcionário é obrigatório")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank(message = "Especialidade é obrigatória")
    @Size(min = 3, max = 50, message = "Especialidade deve ter entre 3 e 50 caracteres")
    private String especialidade;

    @NotNull
    @Pattern(regexp = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$",
            message = "ID inválido.")
    private UUID idSalao;
}
