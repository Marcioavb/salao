package com.Marcio.Salao.salao.infra;

import com.Marcio.Salao.cliente.domain.Cliente;
import com.Marcio.Salao.handler.APIException;
import com.Marcio.Salao.salao.application.repository.SalaoRepository;
import com.Marcio.Salao.salao.domain.Salao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Repository
public class SalaoInfraRepository implements SalaoRepository {
    private final SalaoSpringDataJPARepository salaoSpringDataJPARepository;

    @Override
    public Salao salva(Salao salao) {
        log.info("[inicia] SalaoInfraRepository - salva");
        Salao salaoSalvo = salaoSpringDataJPARepository.save(salao);
        log.info("[finaliza] SalaoInfraRepository - salva");
        return salaoSalvo;
    }

    @Override
    public Salao buscaSalaoPorId(UUID idSalao) {
        log.info("[inicia] SalaoInfraRepository - buscaSalaoPorId");
        Salao salao = salaoSpringDataJPARepository.findById(idSalao)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Salão não encontrado"));
        log.info("[finaliza] SalaoInfraRepository - buscaSalaoPorId");
        return salao;

    }

    @Override
    public Page<Salao> buscaTodosSaloes(Pageable pageable) {
        log.info("[inicia] SalaoInfraRepository - buscaTodossalao");
        Page<Salao> salao = salaoSpringDataJPARepository.findAll(pageable);
        log.info("[finaliza] SalaoInfraRepository - buscaTodossalao");
        return salao;
    }
}
