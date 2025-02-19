package com.Marcio.Salao.funcionario.application.repository;


import com.Marcio.Salao.funcionario.domain.Funcionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface FuncionarioRepository {

    Funcionario salva(Funcionario funcionario);
    Funcionario buscaFuncionarioID(UUID idFuncionario);
    Page<Funcionario> buscaTodosFuncionario(Pageable pageable);
}
