package com.Marcio.Salao.funcionario.application.api;

import com.Marcio.Salao.funcionario.domain.Funcionario;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Value
public class FuncionarioDetalhadoResponse {

    private UUID idFuncionario;
    private String nome;
    private String especialidade;

    public FuncionarioDetalhadoResponse(Funcionario funcionario) {
        this.idFuncionario = funcionario.getIdFuncionario();
        this.nome = funcionario.getNome();
        this.especialidade = funcionario.getEspecialidade();
    }
}
