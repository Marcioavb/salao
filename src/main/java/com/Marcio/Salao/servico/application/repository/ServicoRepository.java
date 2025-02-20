package com.Marcio.Salao.servico.application.repository;

import com.Marcio.Salao.servico.domain.Servico;

import java.util.UUID;

public interface ServicoRepository {
    Servico salva(Servico servico);
    Servico buscaServicoPoId(UUID idServico);
}
