package com.Marcio.Salao.salao.application.api;

import com.Marcio.Salao.salao.domain.Salao;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@ToString
@Getter
public class SalaoResponse {

    private UUID idSalao;
   // private String donoSalao;
    private String endereco;
    private String telefone;

    public SalaoResponse(Salao salao) {
        this.idSalao = salao.getIdSalao();
        //this.donoSalao = salao.getNomeSalao();
        this.endereco = salao.getEndereco();
        this.telefone = salao.getTelefone();
    }
}
