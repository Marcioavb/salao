package com.Marcio.Salao.funcionario.application.api;

import com.Marcio.Salao.funcionario.domain.Funcionario;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@ToString
@Getter
public class FuncionarioResponse {

    private UUID idFuncionario;
    private String nome;
    private String especialidade;
    private LocalDateTime dataCadastro;


    public FuncionarioResponse(Funcionario funcionario) {
        this.idFuncionario = funcionario.getIdFuncionario();
        this.nome = funcionario.getNome();
        this.especialidade = funcionario.getEspecialidade();
        this.dataCadastro = funcionario.getDataCadastro();
    }
}
