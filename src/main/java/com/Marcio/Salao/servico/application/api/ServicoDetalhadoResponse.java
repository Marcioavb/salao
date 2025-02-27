package com.Marcio.Salao.servico.application.api;

import com.Marcio.Salao.servico.domain.Servico;
import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
public class ServicoDetalhadoResponse {

    private UUID idServico;
    private String nomeServico;
    private String descricao;
    private BigDecimal preco;
    private Integer duracao;

    public ServicoDetalhadoResponse(Servico servico) {
        this.idServico = servico.getIdServico();
        this.nomeServico = servico.getNomeServico();
        this.descricao = servico.getDescricao();
        this.preco = servico.getPreco();
        this.duracao = servico.getDuracao();
    }
}
