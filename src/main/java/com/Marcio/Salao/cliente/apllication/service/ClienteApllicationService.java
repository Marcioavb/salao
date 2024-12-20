package com.Marcio.Salao.cliente.apllication.service;

import com.Marcio.Salao.cliente.apllication.api.ClienteDetalhadoResponse;
import com.Marcio.Salao.cliente.apllication.api.ClienteRequest;
import com.Marcio.Salao.cliente.apllication.api.ClienteResponse;
import com.Marcio.Salao.cliente.apllication.repository.ClienteRepository;
import com.Marcio.Salao.cliente.domain.Cliente;
import com.Marcio.Salao.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Service
public class ClienteApllicationService implements ClienteService {
    private final ClienteRepository clienteRepository;

    @Override
    public ClienteResponse criacliente(ClienteRequest clienteRequest) {
        log.info("[inicia] ClienteApllicationService - criacliente");
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
}

