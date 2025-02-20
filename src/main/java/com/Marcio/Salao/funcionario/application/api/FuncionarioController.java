package com.Marcio.Salao.funcionario.application.api;


import com.Marcio.Salao.funcionario.application.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@Log4j2
public class FuncionarioController implements FuncionarioApi {
    private final FuncionarioService funcionarioService;

    @Override
    public FuncionarioResponse cadastraFuncionarios(FuncionarioRequest funcionarioRequest) {
        log.info("[inicia] FuncionarioController - cadastraFuncionarios");
        FuncionarioResponse funcionarioCriado = funcionarioService.criaFuncionario(funcionarioRequest);
        log.info("[finaliza] FuncionarioController - cadastraFuncionarios");
        return funcionarioCriado;
    }

    @Override
    public FuncionarioDetalhadoResponse buscafuncionarioPorId(UUID idFuncionario) {
        log.info("[inicia] FuncionarioController - buscafuncionarioPorId");
        FuncionarioDetalhadoResponse funcionario = funcionarioService.buscaFuncionarioPorId(idFuncionario);
        log.info("[finaliza] FuncionarioController - buscafuncionarioPorId");
        return funcionario;
    }

    @Override
    public Page<FuncionarioDetalhadoResponse> listaTodosFuncionarios(Pageable pageable) {
        log.info("[inicia] FuncionarioController - listaTodosFuncionarios");
        Page<FuncionarioDetalhadoResponse> funcionarios = funcionarioService.buscaTodosFuncionarios(pageable);
        log.info("[finaliza] FuncionarioController - listaTodosFuncionarios");
        return funcionarios;
    }
}
