package com.Marcio.Salao.auth.security.service;

import java.util.Optional;

import com.Marcio.Salao.auth.credencial.application.repository.CredencialRepository;
import com.Marcio.Salao.handler.APIException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class AutenticacaoSecurityService implements UserDetailsService {
    private final CredencialRepository credencialRepository;

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        log.info("[inicio] AutenticacaoSecurityService - buscando credencial pelo usuario");
        var credencial = credencialRepository.buscaCredencialPorUsuario(usuario);
        log.info("[finaliza] AutenticacaoSecurityService - buscando credencial pelo usuario");
        return Optional.ofNullable(credencial).orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "" +
                "Não existe credencial para o Usuario informado!"));
    }
}
