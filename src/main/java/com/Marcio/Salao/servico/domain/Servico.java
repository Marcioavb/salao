package com.Marcio.Salao.servico.domain;
import com.Marcio.Salao.salao.domain.Salao;
import com.Marcio.Salao.servico.application.api.ServicoRequest;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@ToString
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID idServico;
    @NotBlank
    private String nomeServico;
    private String descricao;
    @NotNull
    @Positive(message = "A duração deve ser maior que zero")
    private Integer duracao;
    @NotNull
    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(name = "id_salao", nullable = false)
    private Salao salao;

    private LocalDateTime dataCadastro;

    public Servico(ServicoRequest servicoRequest,Salao salao) {
        this.nomeServico = servicoRequest.getNomeServico();
        this.descricao = servicoRequest.getDescricao();
        this.duracao = servicoRequest.getDuracao();
        this.preco = servicoRequest.getPreco();
        this.salao = salao;
        this.dataCadastro = LocalDateTime.now();
    }
}
