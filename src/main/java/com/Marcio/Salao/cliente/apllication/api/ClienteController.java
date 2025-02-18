package com.Marcio.Salao.cliente.apllication.api;

import com.Marcio.Salao.cliente.apllication.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ClienteController implements ClienteAPI {
    private final ClienteService clienteService;

    @Override
    public ClienteResponse cadastraCliente(ClienteRequest clienteRequest) {
        log.info("[inicia] ClienteController - cadastraCliente");
        ClienteResponse clienteCriado = clienteService.criacliente(clienteRequest);
        log.info("[finaliza] ClienteController - cadastraCliente");
        return clienteCriado;
    }

    @Override
    public ClienteDetalhadoResponse buscaClientePorId(UUID idCliente) {
        log.info("[inicia] ClienteController - buscaClientePorId");
        ClienteDetalhadoResponse cliente = clienteService.buscaclientePorId(idCliente);
        log.info("[finaliza] ClienteController - buscaClientePorId");
        return cliente;
    }

//    @Override
//    public List<ClienteDetalhadoResponse> listaTodosClientes(Pageable pageable) {
//        log.info("[inicia] ClienteController - listaTodosClientes");
//        List<ClienteDetalhadoResponse> clientes = clienteService.listaTodosClientes(pageable);
//        log.info("[finaliza] ClienteController - listaTodosClientes");
//        return clientes;
//    }

    public Page<ClienteDetalhadoResponse> listaTodosClientes(Pageable pageable) {
        log.info("[inicia] ClienteController - listaTodosClientes");
        Page<ClienteDetalhadoResponse> clientes = clienteService.listaTodosClientes(pageable);
        log.info("[finaliza] ClienteController - listaTodosClientes");
        return clientes;
    }
}
