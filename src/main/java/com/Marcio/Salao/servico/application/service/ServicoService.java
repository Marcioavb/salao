package com.Marcio.Salao.servico.application.service;

import com.Marcio.Salao.servico.application.api.ServicoRequest;
import com.Marcio.Salao.servico.application.api.ServicoResponse;

public interface ServicoService {
    ServicoResponse cadastraNovoServico(ServicoRequest servicoRequest);
}
