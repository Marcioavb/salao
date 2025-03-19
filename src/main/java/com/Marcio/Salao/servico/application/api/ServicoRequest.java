package com.Marcio.Salao.servico.application.api;

import lombok.Getter;
import lombok.ToString;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@ToString
public class ServicoRequest {

    @NotBlank(message = "Nome do serviço é obrigatório")
    private String nomeServico;

    private String descricao;

    @NotNull(message = "Preço é obrigatório")
    @Positive(message = "O preço deve ser maior que zero")
    private BigDecimal preco;

    @NotNull(message = "Duração é obrigatória")
    @Positive(message = "A duração deve ser maior que zero")
    private Integer duracao;

    @NotNull
    private UUID idSalao;
}
