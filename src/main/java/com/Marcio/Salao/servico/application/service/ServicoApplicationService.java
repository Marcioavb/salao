package com.Marcio.Salao.servico.application.service;

import com.Marcio.Salao.servico.application.api.ServicoRequest;
import com.Marcio.Salao.servico.application.api.ServicoResponse;
import com.Marcio.Salao.servico.application.repository.ServicoRepository;
import com.Marcio.Salao.servico.domain.Servico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class ServicoApplicationService implements ServicoService {
    private final ServicoRepository servicoRepository;
    @Override
    public ServicoResponse cadastraNovoServico(ServicoRequest servicoRequest) {
        log.info("[inicia] ServicoApplicationService - cadastraNovoServico");
        Servico servico = servicoRepository.salva(new Servico(servicoRequest));
        log.info("[finaliza] ServicoApplicationService - cadastraNovoServico");
        return new ServicoResponse(servico);
    }
}
