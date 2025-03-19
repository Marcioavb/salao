package com.Marcio.Salao.auth.autenticacao.application.api;


import com.Marcio.Salao.auth.autenticacao.domain.Token;
import lombok.Value;

import java.util.UUID;

@Value
public class TokenResponse {
	private String token;
	private String tipo;
	private UUID idUsuario;

	public TokenResponse(Token token) {
		this.token = token.getToken();
		this.tipo = token.getTipo();
		this.idUsuario = token.getIdUsuario();
	}
}
