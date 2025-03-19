package com.Marcio.Salao.salao.application.repository;

import com.Marcio.Salao.salao.domain.Salao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface SalaoRepository {

    Salao salva(Salao salao);

    Page<Salao> buscaTodosSaloes(Pageable pageable);
    Salao buscaSalaoPorId(UUID idSalao);
}
