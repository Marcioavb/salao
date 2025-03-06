package com.Marcio.Salao.salao.application.service;

import com.Marcio.Salao.salao.application.api.SalaoDetalhadoResponse;
import com.Marcio.Salao.salao.application.api.SalaoRequest;
import com.Marcio.Salao.salao.application.api.SalaoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface SalaoService {
    SalaoResponse criaSalao(SalaoRequest salaoRequest);
    SalaoDetalhadoResponse buscasalaoPorId(UUID idSalao);
    Page<SalaoDetalhadoResponse> buscaTodosSaloes(Pageable pageable);
}
