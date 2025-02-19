package com.Marcio.Salao.funcionario.application.service;

import com.Marcio.Salao.funcionario.application.api.FuncionarioRequest;
import com.Marcio.Salao.funcionario.application.api.FuncionarioResponse;
import com.Marcio.Salao.funcionario.application.repository.FuncionarioRepository;
import com.Marcio.Salao.funcionario.domain.Funcionario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class FuncionarioApllicationService implements FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;
    @Override
    public FuncionarioResponse criaFuncionario(FuncionarioRequest funcionarioRequest) {
        log.info("[inicia] FuncionarioApllicationService - criaFuncionario");
        Funcionario funcionario = funcionarioRepository.salva(new Funcionario(funcionarioRequest));
        log.info("[finaliza] FuncionarioApllicationService - criaFuncionario");
        return new FuncionarioResponse(funcionario);
    }
}