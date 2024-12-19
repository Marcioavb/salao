package com.Marcio.Salao.cliente.apllication.repository;

import com.Marcio.Salao.cliente.domain.Cliente;

import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository {
    Cliente salva(Cliente cliente);
}
