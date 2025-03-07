package com.Marcio.Salao.auth.credencial.application.service;

import javax.validation.Valid;

import com.Marcio.Salao.auth.credencial.application.repository.CredencialRepository;
import com.Marcio.Salao.auth.credencial.domain.Credencial;
import com.Marcio.Salao.auth.usuario.api.UsuarioNovoRequest;

import com.Marcio.Salao.auth.usuario.domain.Usuario;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class CrendencialApplicationService implements CredencialService {
	private final CredencialRepository credencialRepository;
	
	@Override
	public void criaNovaCredencial(Usuario usuario, @Valid UsuarioNovoRequest usuarioNovo) {
		log.info("[inicia] CrendencialService - criaNovaCredencial");
		var novaCredencial = new Credencial(usuario, usuarioNovo.getEmail(), usuarioNovo.getSenha());
		credencialRepository.salva(novaCredencial);
		log.info("[finaliza] CrendencialService - criaNovaCredencial");
	}
	
	@Override
	public Credencial buscaCredencialPorUsuario(String usuario) {
		log.info("[inicia] CredencialSpringDataJpaService - buscaCredencial");
		Credencial credencial = credencialRepository.buscaCredencialPorUsuario(usuario);
		log.info("[finaliza] CredencialSpringDataJpaService - buscaCredencial");
		return credencial;
	}
}
