package com.Marcio.Salao.auth.usuario.api.service;

import java.util.UUID;

import javax.validation.Valid;

import com.Marcio.Salao.auth.usuario.api.UsuarioCriadoResponse;
import com.Marcio.Salao.auth.usuario.api.UsuarioNovoRequest;

public interface UsuarioService {

	UsuarioCriadoResponse criaNovoUsuario(@Valid UsuarioNovoRequest usuarioNovo);
	UsuarioCriadoResponse buscaUsuarioPorId(UUID idUsuario);
}
