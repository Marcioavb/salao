package com.Marcio.Salao.cliente.apllication.repository;

import com.Marcio.Salao.cliente.domain.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;


public interface ClienteRepository {
    Cliente salva(Cliente cliente);

    Cliente buscaPorId(UUID idCliente);
    boolean existeClientePorTelefone(String telefone);
    Page<Cliente> listaTodosClientes(Pageable pageable);
}
