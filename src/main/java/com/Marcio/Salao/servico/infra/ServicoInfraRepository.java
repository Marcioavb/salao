package com.Marcio.Salao.servico.infra;

import com.Marcio.Salao.servico.application.repository.ServicoRepository;
import com.Marcio.Salao.servico.domain.Servico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

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
}
