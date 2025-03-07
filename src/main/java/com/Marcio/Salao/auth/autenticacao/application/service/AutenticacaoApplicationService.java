package com.Marcio.Salao.auth.autenticacao.application.service;

import com.Marcio.Salao.auth.autenticacao.domain.Token;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public interface AutenticacaoApplicationService {
    Token autentica(UsernamePasswordAuthenticationToken userCredentials);
    Token reativaToken(String tokenExpirado);
}
