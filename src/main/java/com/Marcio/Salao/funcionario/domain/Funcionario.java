package com.Marcio.Salao.funcionario.domain;

import com.Marcio.Salao.funcionario.application.api.FuncionarioRequest;
import com.Marcio.Salao.salao.domain.Salao;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Getter
@ToString
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
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

    @ManyToOne
    @JoinColumn(name = "id_salao", nullable = false)
    private Salao salao;


    public Funcionario(FuncionarioRequest funcionarioRequest, Salao salao) {
        this.nome = funcionarioRequest.getNome();
        this.especialidade = funcionarioRequest.getEspecialidade();
        this.dataCadastro = LocalDateTime.now();
        this.salao = salao;
    }
}
