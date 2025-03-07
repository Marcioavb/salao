package com.Marcio.Salao.auth.credencial.infra;

import com.Marcio.Salao.auth.credencial.application.repository.CredencialRepository;
import com.Marcio.Salao.auth.credencial.domain.Credencial;
import com.Marcio.Salao.handler.APIException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CredencialRepositoryJPA implements CredencialRepository {
	private final CredencialJPARepository credencialJPARepository;

	@Override
	public Credencial salva(Credencial credencial) {
		log.info("[start] CredencialRepositoryJPA - salva");
		credencialJPARepository.save(credencial);
		log.info("[finish] CredencialRepositoryJPA - salva");
		return credencial;
	}

	@Override
	public Credencial buscaCredencialPorUsuario(String usuario) {
		log.info("[start] CredencialRepositoryJPA - buscaCredencialPorUsuario");
		var credencial = credencialJPARepository.findByUsuario(usuario).orElseThrow(
				() -> APIException.build(HttpStatus.NOT_FOUND, "Não existe credencial para o Usuario informado!"));
		log.info("[start] CredencialRepositoryJPA - buscaCredencialPorUsuario");
		return credencial;
	}
}