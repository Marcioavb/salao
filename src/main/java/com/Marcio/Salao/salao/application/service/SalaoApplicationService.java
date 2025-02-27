package com.Marcio.Salao.salao.application.service;

import com.Marcio.Salao.handler.APIException;
import com.Marcio.Salao.salao.application.api.SalaoDetalhadoResponse;
import com.Marcio.Salao.salao.application.api.SalaoRequest;
import com.Marcio.Salao.salao.application.api.SalaoResponse;
import com.Marcio.Salao.salao.application.repository.SalaoRepository;
import com.Marcio.Salao.salao.domain.Salao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Log4j2
@Service
public class SalaoApplicationService implements SalaoService {
    private final SalaoRepository salaoRepository;

    @Override
    public SalaoResponse criaSalao(SalaoRequest salaoRequest) {
        log.info("[inicia] SalaoApplicationService - criaSalao");
        Salao salao = salaoRepository.salva(new Salao(salaoRequest));
        log.info("[finaliza] SalaoApplicationService - criaSalao");
        return new SalaoResponse(salao);
    }

    @Override
    public SalaoDetalhadoResponse buscasalaoPorId(UUID idSalao) {
        log.info("[inicia] SalaoApplicationService - buscaSalaoPorId");
        Salao salao = salaoRepository.buscaSalaoPorId(idSalao);
        log.info("[finaliza] SalaoApplicationService - buscaSalaoPorId");
        return new SalaoDetalhadoResponse(salao);
    }

    @Override
    public Page<SalaoDetalhadoResponse> buscaTodosSaloes(Pageable pageable) {
        log.info("[inicia] SalaoApplicationService - buscaTodosSaloes");
        Page<Salao> saloes  = salaoRepository.buscaTodosSaloes(pageable);
        log.info("[finaliza] SalaoApplicationService - buscaTodosSaloes");
        return saloes
                .map(SalaoDetalhadoResponse::new);
    }
}
