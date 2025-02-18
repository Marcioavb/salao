package com.Marcio.Salao.cliente.infra;

import com.Marcio.Salao.cliente.apllication.repository.ClienteRepository;
import com.Marcio.Salao.cliente.domain.Cliente;
import com.Marcio.Salao.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Repository
public class ClienteInfraRepository implements ClienteRepository {
    private final ClienteSpringDataJPARepository clienteSpringDataJPARepository;

    @Override
    public Cliente salva(Cliente cliente) {
        log.info("[inicia] ClienteInfraRepository- salva");
        clienteSpringDataJPARepository.save(cliente);
        log.info("[finaliza] ClienteInfraRepository- salva");
        return cliente;
    }

    @Override
    public Cliente buscaPorId(UUID idCliente) {
        log.info("[inicia] ClienteInfraRepository - buscaPorId - idCliente: {}", idCliente);
        Cliente cliente = clienteSpringDataJPARepository.findById(idCliente)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
        log.info("[finaliza] ClienteInfraRepository - buscaPorId");
        return cliente;
    }

    @Override
    public boolean existeClientePorTelefone(String telefone) {
        log.info("[inicia] ClienteInfraRepository - existeClientePorTelefone");
        boolean existe = clienteSpringDataJPARepository.existsByTelefone(telefone);
        log.info("[finaliza] ClienteInfraRepository - existeClientePorTelefone");
        return existe;
    }

    @Override
    public Page<Cliente> listaTodosClientes(Pageable pageable) {
        log.info("[inicia] ClienteInfraRepository- listaTodosClientes");
        Page<Cliente> clientes = clienteSpringDataJPARepository.findAll(pageable);
        log.info("[finaliza] ClienteInfraRepository- listaTodosClientes");
        return clientes;
    }
}