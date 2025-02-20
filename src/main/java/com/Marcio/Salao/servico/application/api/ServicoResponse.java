package com.Marcio.Salao.servico.application.api;

import com.Marcio.Salao.servico.domain.Servico;
import lombok.Getter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class ServicoResponse {
    private UUID idServico;
    private String nome;
    private String descricao;

    private Integer duracao;
    private BigDecimal preco;


    private LocalDateTime dataCadastro;

    public ServicoResponse(Servico servico) {
        this.idServico = servico.getIdServico();
        this.nome = servico.getNome();
        this.descricao = servico.getDescricao();
        this.preco = servico.getPreco();
        this.duracao = servico.getDuracao();
        this.dataCadastro = servico.getDataCadastro();
    }
}