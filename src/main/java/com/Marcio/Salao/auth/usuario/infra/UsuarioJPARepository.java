package com.Marcio.Salao.auth.usuario.infra;

import java.util.Optional;
import java.util.UUID;

import com.Marcio.Salao.auth.usuario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioJPARepository extends JpaRepository <Usuario, UUID>{

	Optional<Usuario> findByIdUsuario(UUID idUsuario);
}
