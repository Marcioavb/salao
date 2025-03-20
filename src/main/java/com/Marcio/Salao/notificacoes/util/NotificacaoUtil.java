package com.Marcio.Salao.notificacoes.util;

import com.Marcio.Salao.agendamento.domain.Agendamento;
import java.time.format.DateTimeFormatter;

public class NotificacaoUtil {

    public static String formatarMensagemAgendamento(String acao, Agendamento agendamento) {
        return String.format("Agendamento %s: %s para %s em %s com %s",
                acao,
                agendamento.getServico().getNomeServico(),
                agendamento.getCliente().getNomeCompleto(),
                agendamento.getDataHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
                agendamento.getFuncionario().getNome());
    }
}
