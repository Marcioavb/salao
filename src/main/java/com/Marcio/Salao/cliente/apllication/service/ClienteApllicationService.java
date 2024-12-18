package com.Marcio.Salao.cliente.apllication.service;

import com.Marcio.Salao.cliente.apllication.api.ClienteRequest;
import com.Marcio.Salao.cliente.apllication.api.ClienteResponse;
import com.Marcio.Salao.cliente.apllication.repository.ClienteRepository;
import com.Marcio.Salao.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

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
}

