package com.Marcio.Salao.servico.application.service;

import com.Marcio.Salao.servico.application.api.ServicoDetalhadoResponse;
import com.Marcio.Salao.servico.application.api.ServicoRequest;
import com.Marcio.Salao.servico.application.api.ServicoResponse;

import java.util.UUID;

public interface ServicoService {
    ServicoResponse cadastraNovoServico(ServicoRequest servicoRequest);
    ServicoDetalhadoResponse buscaServicoPorId(UUID idServico);
}
