package com.Marcio.Salao.servico.application.repository;

import com.Marcio.Salao.servico.domain.Servico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ServicoRepository {
    Servico salva(Servico servico);
    Servico buscaServicoPoId(UUID idServico);
    Page<Servico> buscaTodosServicos(Pageable pageable);
}
