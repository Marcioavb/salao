package com.Marcio.Salao.cliente.infra;

import com.Marcio.Salao.cliente.apllication.repository.ClienteRepository;
import com.Marcio.Salao.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Repository
public class ClienteInfraRepository implements ClienteRepository {
    private final ClienteSpringDataJPARepository clienteSpringDataJPARepository;

    @Override
    public Cliente salva(Cliente cliente) {
        log.info("[inicia] ClienteInfraRepository- salva");
        clienteSpringDataJPARepository.save(cliente);
        log.info("[finaliza] ClienteInfraRepository- salva");
        return cliente;
    }
}
