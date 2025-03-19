package com.Marcio.Salao.servico.infra;

import com.Marcio.Salao.handler.APIException;
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
public class ServicoInfraRepository implements ServicoRepository {
    private final ServicoSpringDataJPARepository servicoSpringDataJPARepository;
    @Override
    public Servico salva(Servico servico) {
        log.info("[inicia] ServicoInfraRepository - salva");
        Servico servicoCriado = servicoSpringDataJPARepository.save(servico);
        log.info("[finaliza] ServicoInfraRepository - salva");
        return servicoCriado;
    }

    @Override
    public Servico buscaServicoPoId(UUID idServico) {
        log.info("[inicia] ServicoInfraRepository - buscaServicoPorId");
        Servico servico = servicoSpringDataJPARepository.findById(idServico)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "serviço não encontrado"));
        log.info("[finaliza] ServicoInfraRepository - buscaServicoPorId");
        return servico;
    }

    @Override
    public Page<Servico> buscaTodosServicos(Pageable pageable) {
        log.info("[inicia] ServicoInfraRepository - buscaTodosServicos");
        Page<Servico> servicos = servicoSpringDataJPARepository.findAll(pageable);
        log.info("[finaliza] ServicoInfraRepository - buscaTodosServicos");
        return servicos;
    }
}
