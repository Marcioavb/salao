package com.Marcio.Salao.servico.application.api;

import com.Marcio.Salao.servico.application.service.ServicoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ServicoController implements ServicoApi {
    private final ServicoService servicoService;
    @Override
    public ServicoResponse cadastraServico(ServicoRequest servicoRequest) {
        log.info("[inicia] ServicoController - cadastraServico");
        ServicoResponse servicoCriado = servicoService.cadastraNovoServico(servicoRequest);
        log.info("[finaliza] ServicoController - cadastraServico");
        return servicoCriado;
    }

    @Override
    public ServicoDetalhadoResponse buscaServicoPorId(UUID idServico) {
        log.info("[inicia] ServicoController - buscaServicoPorId");

        log.info("[finaliza] ServicoController - buscaServicoPorId");
        return null;
    }
}
