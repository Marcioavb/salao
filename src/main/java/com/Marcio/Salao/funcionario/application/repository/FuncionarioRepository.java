package com.Marcio.Salao.funcionario.application.repository;


import com.Marcio.Salao.funcionario.domain.Funcionario;

import java.util.UUID;

public interface FuncionarioRepository {

    Funcionario salva(Funcionario funcionario);
    Funcionario buscaFuncionarioID(UUID idFuncionario);
}
