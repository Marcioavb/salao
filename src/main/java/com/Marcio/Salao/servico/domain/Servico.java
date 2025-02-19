package com.Marcio.Salao.servico.domain;
import com.Marcio.Salao.servico.application.api.ServicoRequest;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@ToString
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID idServico;
    @NotBlank
    private String nome;
    private String descricao;
    @NotNull
    private BigDecimal preco;
    private LocalDateTime dataCadastro;

    public Servico(ServicoRequest request) {
        this.nome = request.getNome();
        this.descricao = request.getDescricao();
        this.preco = request.getPreco();
        this.dataCadastro = LocalDateTime.now();
    }
}