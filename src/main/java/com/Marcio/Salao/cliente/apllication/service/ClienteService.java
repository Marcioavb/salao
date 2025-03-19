package com.Marcio.Salao.cliente.apllication.service;

import com.Marcio.Salao.cliente.apllication.api.ClienteDetalhadoResponse;
import com.Marcio.Salao.cliente.apllication.api.ClienteRequest;
import com.Marcio.Salao.cliente.apllication.api.ClienteResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ClienteService {
    ClienteResponse criacliente(ClienteRequest clienteRequest);
    ClienteDetalhadoResponse buscaclientePorId(UUID idCliente);
    Page<ClienteDetalhadoResponse> listaTodosClientes(Pageable pageable);
}
