package com.Marcio.Salao.funcionario.application.service;

import com.Marcio.Salao.funcionario.application.api.FuncionarioDetalhadoResponse;
import com.Marcio.Salao.funcionario.application.api.FuncionarioRequest;
import com.Marcio.Salao.funcionario.application.api.FuncionarioResponse;
import com.Marcio.Salao.funcionario.application.repository.FuncionarioRepository;
import com.Marcio.Salao.funcionario.domain.Funcionario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

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

    @Override
    public FuncionarioDetalhadoResponse buscaFuncionarioPorId(UUID idFuncionario) {
        log.info("[inicia] FuncionarioApllicationService - buscaFuncionarioPorId");
        Funcionario funcionario = funcionarioRepository.buscaFuncionarioID(idFuncionario);
        log.info("[finaliza] FuncionarioApllicationService - buscaFuncionarioPorId");
        return new FuncionarioDetalhadoResponse(funcionario);
    }
}