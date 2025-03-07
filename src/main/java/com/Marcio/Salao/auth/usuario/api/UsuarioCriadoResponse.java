package com.Marcio.Salao.auth.usuario.api;

import java.util.UUID;

import com.Marcio.Salao.auth.usuario.domain.Usuario;

import lombok.Value;
@Value
public class UsuarioCriadoResponse {
	
	private final UUID idUsuario;
	private final String email;
	
	public UsuarioCriadoResponse(Usuario usuario) {
		this.idUsuario = usuario.getIdUsuario();
		this.email = usuario.getEmail();
	}
}