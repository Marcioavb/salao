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
    private String mensagem; // Mensagem da notificação
    private String tipo; // Tipo da notificação (ex: AGENDAMENTO, CANCELAMENTO, FINALIZADO)
    private UUID idSalao; // ID do salão relacionado
    private UUID idFuncionario; // ID do funcionário relacionado
    private UUID idCliente; // ID do cliente relacionado
}