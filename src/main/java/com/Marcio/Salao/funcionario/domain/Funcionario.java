package com.Marcio.Salao.funcionario.domain;

import com.Marcio.Salao.funcionario.application.api.FuncionarioRequest;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@ToString
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID idFuncionario;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String nome;

    @Column(nullable = false, length = 50)
    @NotBlank
    private String especialidade;

    private LocalDateTime dataCadastro;

//    @OneToMany(mappedBy = "funcionario")
//    private List<Agendamento> agendamentos;


    public Funcionario(FuncionarioRequest funcionarioRequest) {
        this.nome = funcionarioRequest.getNome();
        this.especialidade = funcionarioRequest.getEspecialidade();
        this.dataCadastro = LocalDateTime.now();
    }
}