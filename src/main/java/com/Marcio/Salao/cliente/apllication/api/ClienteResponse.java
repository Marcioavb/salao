package com.Marcio.Salao.cliente.apllication.api;

import com.Marcio.Salao.cliente.domain.Cliente;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@ToString
@Getter
public class ClienteResponse {
    private UUID idCliente;

    public ClienteResponse(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
    }
}
