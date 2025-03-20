package com.Marcio.Salao.notificacoes.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Notificacao {
    private String mensagem;
    private String tipo;
    private UUID idSalao;
    private UUID idFuncionario;
    private UUID idCliente;
    private String status;
    private String tempoRestante;
}
