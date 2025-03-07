package com.Marcio.Salao.auth.credencial.application.repository;

import com.Marcio.Salao.auth.credencial.domain.Credencial;

public interface CredencialRepository {
	Credencial salva(Credencial credencial);
	Credencial buscaCredencialPorUsuario(String usuario);
}
