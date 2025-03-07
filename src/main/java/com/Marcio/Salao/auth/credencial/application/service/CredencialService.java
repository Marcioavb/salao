package com.Marcio.Salao.auth.credencial.application.service;

import javax.validation.Valid;

import com.Marcio.Salao.auth.credencial.domain.Credencial;
import com.Marcio.Salao.auth.usuario.api.UsuarioNovoRequest;
import com.Marcio.Salao.auth.usuario.domain.Usuario;
public interface CredencialService {
	void criaNovaCredencial(Usuario usuario, @Valid UsuarioNovoRequest usuarioNovo);
	Credencial buscaCredencialPorUsuario(String usuario);
}
