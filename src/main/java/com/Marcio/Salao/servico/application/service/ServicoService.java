package com.Marcio.Salao.servico.application.service;

import com.Marcio.Salao.servico.application.api.ServicoDetalhadoResponse;
import com.Marcio.Salao.servico.application.api.ServicoRequest;
import com.Marcio.Salao.servico.application.api.ServicoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ServicoService {
    ServicoResponse cadastraNovoServico(ServicoRequest servicoRequest);
    ServicoDetalhadoResponse buscaServicoPorId(UUID idServico);
    Page<ServicoDetalhadoResponse> listaTodosServicos(Pageable pageable);
}
