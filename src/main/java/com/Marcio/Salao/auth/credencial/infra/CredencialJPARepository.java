package com.Marcio.Salao.auth.credencial.infra;

import java.util.Optional;
import java.util.UUID;

import com.Marcio.Salao.auth.credencial.domain.Credencial;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CredencialJPARepository extends JpaRepository<Credencial, UUID> {
	Optional<Credencial> findByUsuario(String usuario);
}
