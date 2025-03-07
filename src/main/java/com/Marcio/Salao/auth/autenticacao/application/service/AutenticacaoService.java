package com.Marcio.Salao.auth.autenticacao.application.service;

import com.Marcio.Salao.auth.autenticacao.domain.Token;
import com.Marcio.Salao.auth.credencial.application.service.CredencialService;
import com.Marcio.Salao.auth.credencial.domain.Credencial;
import com.Marcio.Salao.auth.security.service.TokenService;
import com.Marcio.Salao.handler.APIException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class AutenticacaoService implements AutenticacaoApplicationService {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final CredencialService credencialService;

	@Override
	public Token autentica(UsernamePasswordAuthenticationToken userCredentials) {
        log.info("[inicio] AutenticacaoService - autentica");
        var authentication = authenticationManager.authenticate(userCredentials);
        Credencial credencial = (Credencial) authentication.getPrincipal();
        Token token = Token.builder()
                .tipo("Bearer")
                .token(tokenService.gerarToken(authentication))
                .idUsuario(credencial.getUser().getIdUsuario())
                .build();
        log.info("[finaliza] AutenticacaoService - autentica");
		return token;
	}

	@Override
	public Token reativaToken(String tokenExpirado) {
        log.info("[inicio] service - reativaAutenticacao");
        var usuario = extraiUsuario(tokenExpirado);
        Credencial credencial = credencialService.buscaCredencialPorUsuario(usuario);
        log.info("[finaliza] service - reativaAutenticacao");
        return Token.builder().tipo("Bearer")
                .token(tokenService.gerarToken(credencial))
                .build();
	}

    private String extraiUsuario(String tokenExpirado){
        return tokenService.getUsuario(tokenExpirado)
        		.orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "Token Invalido!"));
    }
}
