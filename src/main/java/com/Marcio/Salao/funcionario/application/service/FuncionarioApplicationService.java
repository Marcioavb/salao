package com.Marcio.Salao.funcionario.application.service;

import com.Marcio.Salao.funcionario.application.api.FuncionarioDetalhadoResponse;
import com.Marcio.Salao.funcionario.application.api.FuncionarioRequest;
import com.Marcio.Salao.funcionario.application.api.FuncionarioResponse;
import com.Marcio.Salao.funcionario.application.repository.FuncionarioRepository;
import com.Marcio.Salao.funcionario.domain.Funcionario;
import com.Marcio.Salao.salao.application.repository.SalaoRepository;
import com.Marcio.Salao.salao.domain.Salao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class FuncionarioApplicationService implements FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;
    private final SalaoRepository salaoRepository;
    @Override
    public FuncionarioResponse criaFuncionario(FuncionarioRequest funcionarioRequest) {
        log.info("[inicia] FuncionarioApplicationService - criaFuncionario");

        // Busca o salão pelo ID fornecido no request
        Salao salao = salaoRepository.buscaSalaoPorId(funcionarioRequest.getIdSalao());

        // Cria o funcionário vinculando ao salão
        Funcionario funcionario = funcionarioRepository.salva(new Funcionario(funcionarioRequest, salao));

        log.info("[finaliza] FuncionarioApplicationService - criaFuncionario");
        return new FuncionarioResponse(funcionario);
    }

    @Override
    public FuncionarioDetalhadoResponse buscaFuncionarioPorId(UUID idFuncionario) {
        log.info("[inicia] FuncionarioApllicationService - buscaFuncionarioPorId");
        Funcionario funcionario = funcionarioRepository.buscaFuncionarioID(idFuncionario);
        log.info("[finaliza] FuncionarioApllicationService - buscaFuncionarioPorId");
        return new FuncionarioDetalhadoResponse(funcionario);
    }

    @Override
    public Page<FuncionarioDetalhadoResponse> buscaTodosFuncionarios(Pageable pageable) {
        log.info("[inicia] FuncionarioApllicationService - buscaFuncionario");
        Page<Funcionario> funcionarios = funcionarioRepository.buscaTodosFuncionario(pageable);
        log.info("[finaliza] FuncionarioApllicationService - buscaFuncionario");
        return funcionarios
                .map(FuncionarioDetalhadoResponse::new);
    }
}
