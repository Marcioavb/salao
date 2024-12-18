package com.Marcio.Salao.cliente.apllication.service;

import com.Marcio.Salao.cliente.apllication.api.ClienteRequest;
import com.Marcio.Salao.cliente.apllication.api.ClienteResponse;

public interface ClienteService {
    ClienteResponse criacliente(ClienteRequest clienteRequest);
}
