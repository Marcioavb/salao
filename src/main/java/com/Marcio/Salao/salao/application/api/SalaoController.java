package com.Marcio.Salao.salao.application.api;

import com.Marcio.Salao.cliente.apllication.api.ClienteDetalhadoResponse;
import com.Marcio.Salao.funcionario.application.api.FuncionarioDetalhadoResponse;
import com.Marcio.Salao.salao.application.service.SalaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@Log4j2
@RestController
public class SalaoController implements SalaoApi {
    private final SalaoService salaoService;

    @Override
    public SalaoResponse cadastraSalao(SalaoRequest salaoRequest) {
        log.info("[inicia] SalaoController - cadastraSalao");
        SalaoResponse salaoCriado = salaoService.criaSalao(salaoRequest);
        log.info("[finaliza] SalaoController - cadastraSalao");
        return salaoCriado;
    }

    @Override
    public SalaoDetalhadoResponse buscaSalaoPorId(UUID idSalao) {
        log.info("[inicia] SalaoController - cadastraSalao" );
        SalaoDetalhadoResponse salao = salaoService.buscasalaoPorId(idSalao);
        log.info("[finaliza] SalaoController - cadastraSalao");
        return salao;
    }

    @Override
    public Page<SalaoDetalhadoResponse> listaTodosSaloes(Pageable pageable) {
        log.info("[inicia] SalaoController - listaTodosSaloes ");
        Page<SalaoDetalhadoResponse> todosSaloes = salaoService.buscaTodosSaloes(pageable);
        log.info("[finaliza] SalaoController - listaTodosSaloes");
        return todosSaloes;
    }
}
