package com.Marcio.Salao.cliente.apllication.service;

import com.Marcio.Salao.cliente.apllication.api.ClienteDetalhadoResponse;
import com.Marcio.Salao.cliente.apllication.api.ClienteRequest;
import com.Marcio.Salao.cliente.apllication.api.ClienteResponse;

import java.util.UUID;

public interface ClienteService {
    ClienteResponse criacliente(ClienteRequest clienteRequest);
    ClienteDetalhadoResponse buscaclientePorId(UUID idCliente);
}
