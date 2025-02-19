package com.Marcio.Salao.funcionario.infra;

import com.Marcio.Salao.cliente.domain.Cliente;
import com.Marcio.Salao.funcionario.application.repository.FuncionarioRepository;
import com.Marcio.Salao.funcionario.domain.Funcionario;
import com.Marcio.Salao.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
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
        funcionarioSpringDataJPARepository.save(funcionario);
        log.info("[finaliza] FuncionarioInfraRepository - salva");
        return funcionario;
    }

    @Override
    public Funcionario buscaFuncionarioID(UUID idFuncionario) {
        log.info("[inicia] FuncionarioInfraRepository - buscaFunciorioID");
        Funcionario funcionario = funcionarioSpringDataJPARepository.findById(idFuncionario)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "funcionario não encontrado"));
        log.info("[finaliza] FuncionarioInfraRepository - buscaFunciorioID");
        return funcionario;
    }
}
