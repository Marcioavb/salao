package com.Marcio.Salao.salao.infra;

import com.Marcio.Salao.salao.domain.Salao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SalaoSpringDataJPARepository extends JpaRepository<Salao, UUID> {
}
