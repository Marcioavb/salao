package com.Marcio.Salao.funcionario.application.api;


import com.Marcio.Salao.funcionario.application.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

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
}
