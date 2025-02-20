package com.Marcio.Salao.servico.infra;

import com.Marcio.Salao.servico.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ServicoSpringDataJPARepository extends JpaRepository<Servico, UUID> {
}
