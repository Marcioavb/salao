package com.Marcio.Salao.cliente.apllication.api;

import com.Marcio.Salao.cliente.domain.Cliente;
import lombok.Value;

@Value
public class ClienteDetalhadoResponse {
    private String idCliente;
    private String nomeCompleto;
    private String telefone;


    public ClienteDetalhadoResponse(Cliente cliente) {
        this.idCliente = cliente.getIdCliente().toString();
        this.nomeCompleto = cliente.getNomeCompleto();
        this.telefone = cliente.getTelefone();
    }
}
