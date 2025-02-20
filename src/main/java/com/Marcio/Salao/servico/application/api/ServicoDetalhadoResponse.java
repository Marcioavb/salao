package com.Marcio.Salao.servico.application.api;

import com.Marcio.Salao.servico.domain.Servico;
import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
public class ServicoDetalhadoResponse {

    private UUID idServico;
    private String nome;
    private String descricao;
    private BigDecimal preco;

    public ServicoDetalhadoResponse(Servico servico) {
        this.idServico = servico.getIdServico();
        this.nome = servico.getNome();
        this.descricao = servico.getDescricao();
        this.preco = servico.getPreco();
    }
}
