package com.Marcio.Salao.cliente.apllication.service;

import com.Marcio.Salao.cliente.apllication.api.ClienteDetalhadoResponse;
import com.Marcio.Salao.cliente.apllication.api.ClienteRequest;
import com.Marcio.Salao.cliente.apllication.api.ClienteResponse;
import com.Marcio.Salao.cliente.apllication.repository.ClienteRepository;
import com.Marcio.Salao.cliente.domain.Cliente;
import com.Marcio.Salao.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Log4j2
@RequiredArgsConstructor
@Service
public class ClienteApllicationService implements ClienteService {
    private final ClienteRepository clienteRepository;

    @Override
    public ClienteResponse criacliente(ClienteRequest clienteRequest) {
        log.info("[inicia] ClienteApllicationService - criacliente");
        if (clienteRepository.existeClientePorTelefone(clienteRequest.getTelefone())) {
            throw APIException.build(HttpStatus.CONFLICT, "Telefone já cadastrado!");
        }
        Cliente cliente = clienteRepository.salva(new Cliente(clienteRequest));
        log.info("[finaliza] ClienteApllicationService - criacliente");
        return new ClienteResponse(cliente);
    }

    @Override
    public ClienteDetalhadoResponse buscaclientePorId(UUID idCliente) {
        log.info("[inicia] ClienteApllicationService - buscaclientePorId");
        Cliente cliente = clienteRepository.buscaPorId(idCliente);
        log.info("[finaliza] ClienteApllicationService - buscaclientePorId");
        return new ClienteDetalhadoResponse(cliente);
    }

    @Override
    public Page<ClienteDetalhadoResponse> listaTodosClientes(Pageable pageable) {
        log.info("[inicia] ClienteApllicationService - listaTodosCliente");
        Page<Cliente> clientes = clienteRepository.listaTodosClientes(pageable);
        log.info("[finaliza] ClienteApllicationService - listaTodosCliente");
//        return clientes.getContent().stream() // Extrai a lista de clientes da Page
//                .map(ClienteDetalhadoResponse::new)
//                .collect(Collectors.toList()); // ✅ Usa Collectors
        return clientes.
                map(ClienteDetalhadoResponse::new);
    }
}

