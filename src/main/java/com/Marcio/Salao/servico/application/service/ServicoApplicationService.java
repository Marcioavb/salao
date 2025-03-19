package com.Marcio.Salao.servico.application.service;

import com.Marcio.Salao.handler.APIException;
import com.Marcio.Salao.salao.application.repository.SalaoRepository;
import com.Marcio.Salao.salao.domain.Salao;
import com.Marcio.Salao.servico.application.api.ServicoDetalhadoResponse;
import com.Marcio.Salao.servico.application.api.ServicoRequest;
import com.Marcio.Salao.servico.application.api.ServicoResponse;
import com.Marcio.Salao.servico.application.repository.ServicoRepository;
import com.Marcio.Salao.servico.domain.Servico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class ServicoApplicationService implements ServicoService {
    private final ServicoRepository servicoRepository;
    private final SalaoRepository salaoRepository;

    @Override
    public ServicoResponse cadastraServico(ServicoRequest servicoRequest) {
        log.info("[inicia] ServicoApplicationService - cadastraNovoServico");

        Salao salao = salaoRepository.buscaSalaoPorId(servicoRequest.getIdSalao());

        Servico servico = new Servico(servicoRequest, salao);
        servicoRepository.salva(servico);

        log.info("[finaliza] ServicoApplicationService - cadastraNovoServico");
        return new ServicoResponse(servico);
    }

    @Override
    public ServicoDetalhadoResponse buscaServicoPorId(UUID idServico) {
        log.info("[inicia] ServicoApplicationService - buscaServicoPorId");
        Servico servico = servicoRepository.buscaServicoPoId(idServico);
        log.info("[finaliza] ServicoApplicationService - buscaServicoPorId");
        return new ServicoDetalhadoResponse(servico);
    }

    @Override
    public Page<ServicoDetalhadoResponse> listaTodosServicos(Pageable pageable) {
        log.info("[inicia] ServicoApplicationService - listaTodosServicos");
        Page<Servico> servicos = servicoRepository.buscaTodosServicos(pageable);
        log.info("[finaliza] ServicoApplicationService - listaTodosServicos");
        return servicos
                .map(ServicoDetalhadoResponse::new);
    }
}
