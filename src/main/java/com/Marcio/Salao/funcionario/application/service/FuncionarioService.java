package com.Marcio.Salao.funcionario.application.service;

import com.Marcio.Salao.funcionario.application.api.FuncionarioDetalhadoResponse;
import com.Marcio.Salao.funcionario.application.api.FuncionarioRequest;
import com.Marcio.Salao.funcionario.application.api.FuncionarioResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface FuncionarioService {
    FuncionarioResponse criaFuncionario(FuncionarioRequest funcionarioRequest);
    FuncionarioDetalhadoResponse buscaFuncionarioPorId(UUID idFuncionario);
    Page<FuncionarioDetalhadoResponse> buscaTodosFuncionarios(Pageable pageable);
}
