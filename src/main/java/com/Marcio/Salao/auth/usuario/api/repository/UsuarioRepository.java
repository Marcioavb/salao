package com.Marcio.Salao.auth.usuario.api.repository;

import java.util.UUID;

import com.Marcio.Salao.auth.usuario.domain.Usuario;

public interface UsuarioRepository {
	Usuario salva(Usuario usuario);
	Usuario buscaUsuarioPorId(UUID idUsuario);
}
