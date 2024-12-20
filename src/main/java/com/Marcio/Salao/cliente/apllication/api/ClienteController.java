package com.Marcio.Salao.cliente.apllication.api;

import com.Marcio.Salao.cliente.apllication.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

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
        log.info("[inicia] ClienteController - buscaSuperHeroiPorId - ");
        ClienteDetalhadoResponse cliente = clienteService.buscaclientePorId(idCliente);
        log.info("[finaliza] ClienteController - buscaSuperHeroiPorId - ");
        return cliente;
    }
}
