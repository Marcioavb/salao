package com.Marcio.Salao.salao.application.api;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.UUID;

@ToString
@Getter
public class SalaoRequest {

    @NotBlank
    private String nomeSalao;
    @NotBlank
    private String endereco;
    @NotBlank
    private String telefone;
//    @NotNull
//    private UUID idDono; // ID do usuário dono
    @NotNull
    private LocalTime horarioAbertura;
    @NotNull
    private LocalTime horarioFechamento;
}
