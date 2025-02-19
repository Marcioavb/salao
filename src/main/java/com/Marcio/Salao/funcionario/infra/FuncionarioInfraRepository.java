package com.Marcio.Salao.funcionario.infra;

import com.Marcio.Salao.cliente.domain.Cliente;
import com.Marcio.Salao.funcionario.application.repository.FuncionarioRepository;
import com.Marcio.Salao.funcionario.domain.Funcionario;
import com.Marcio.Salao.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Log4j2
public class FuncionarioInfraRepository implements FuncionarioRepository {
    private final FuncionarioSpringDataJPARepository funcionarioSpringDataJPARepository;

    @Override
    public Funcionario salva(Funcionario funcionario) {
        log.info("[inicia] FuncionarioInfraRepository - salva");
        Funcionario funcionarioSalvo = funcionarioSpringDataJPARepository.save(funcionario);
        log.info("[finaliza] FuncionarioInfraRepository - salva");
        return funcionarioSalvo;
    }

    @Override
    public Funcionario buscaFuncionarioID(UUID idFuncionario) {
        log.info("[inicia] FuncionarioInfraRepository - buscaFuncionarioID");
        Funcionario funcionario = funcionarioSpringDataJPARepository.findById(idFuncionario)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Funcionário não encontrado"));
        log.info("[finaliza] FuncionarioInfraRepository - buscaFuncionarioID");
        return funcionario;
    }

    @Override
    public Page<Funcionario> buscaTodosFuncionario(Pageable pageable) {
        log.info("[inicia] FuncionarioInfraRepository - buscaTodosFuncionario");
        Page<Funcionario> funcionarios = funcionarioSpringDataJPARepository.findAll(pageable);
        log.info("[finaliza] FuncionarioInfraRepository - buscaTodosFuncionario");
        return funcionarios;
    }
}
