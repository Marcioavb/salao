package com.Marcio.Salao.salao.application.api;


import com.Marcio.Salao.salao.domain.Salao;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@ToString
@Getter
public class SalaoDetalhadoResponse {

    private UUID idSalao;
    private String nomeSalao;
    private String endereco;
    private String telefone;
    private LocalTime horarioAbertura;
    private LocalTime horarioFechamento;
    private LocalDateTime dataCadastro;
    //private UUID idDonoSalao;

    public SalaoDetalhadoResponse(Salao salao) {
        this.idSalao = salao.getIdSalao();
        this.nomeSalao = salao.getNomeSalao();
        this.endereco = salao.getEndereco();
        this.telefone = salao.getTelefone();
        this.horarioAbertura = salao.getHorarioAbertura();
        this.horarioFechamento = salao.getHorarioFechamento();
        this.dataCadastro = salao.getDataCadastro();
        //this.idDonoSalao = salao.getIdDonoSalao();
    }
}
