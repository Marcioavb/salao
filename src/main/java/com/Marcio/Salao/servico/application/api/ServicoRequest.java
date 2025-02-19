package com.Marcio.Salao.servico.application.api;

import lombok.Getter;
import lombok.ToString;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@ToString
public class ServicoRequest {
    @NotBlank(message = "Nome do serviço é obrigatório")
    private String nome;

    private String descricao;

    @NotNull(message = "Preço é obrigatório")
    private BigDecimal preco;
}