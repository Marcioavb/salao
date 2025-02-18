package com.Marcio.Salao.cliente.apllication.api;

import com.Marcio.Salao.cliente.domain.Cliente;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@ToString
@Getter
public class ClienteResponse {

        private UUID idCliente;
        private String nomeCompleto;
        private LocalDateTime dataCadastro;

    public ClienteResponse(Cliente cliente) {
            this.idCliente = cliente.getIdCliente();
            this.nomeCompleto = cliente.getNomeCompleto();
            this.dataCadastro = cliente.getDataCadastro();
    }
}
