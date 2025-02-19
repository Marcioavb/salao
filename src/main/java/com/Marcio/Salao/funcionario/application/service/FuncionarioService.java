package com.Marcio.Salao.funcionario.application.service;

import com.Marcio.Salao.funcionario.application.api.FuncionarioRequest;
import com.Marcio.Salao.funcionario.application.api.FuncionarioResponse;

public interface FuncionarioService {
    FuncionarioResponse criaFuncionario(FuncionarioRequest funcionarioRequest);
}
