package com.Marcio.Salao.notificacoes.service;

import com.Marcio.Salao.notificacoes.domain.Notificacao;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoService {

    private final SimpMessagingTemplate messagingTemplate;

    public NotificacaoService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void enviarNotificacao(Notificacao notificacao) {
        // Envia notificação para o salão
        if (notificacao.getIdSalao() != null) {
            messagingTemplate.convertAndSend("/topic/salao/" + notificacao.getIdSalao() + "/notificacoes", notificacao);
            System.out.println("Notificação enviada para o salão " + notificacao.getIdSalao() + ": " + notificacao.getMensagem());
        }

        // Envia notificação para o funcionário
        if (notificacao.getIdFuncionario() != null) {
            messagingTemplate.convertAndSend("/topic/funcionario/" + notificacao.getIdFuncionario() + "/notificacoes", notificacao);
            System.out.println("Notificação enviada para o funcionário " + notificacao.getIdFuncionario() + ": " + notificacao.getMensagem());
        }

        // Envia notificação para o cliente
        if (notificacao.getIdCliente() != null) {
            messagingTemplate.convertAndSend("/topic/cliente/" + notificacao.getIdCliente() + "/notificacoes", notificacao);
            System.out.println("Notificação enviada para o cliente " + notificacao.getIdCliente() + ": " + notificacao.getMensagem());
        }
    }
}
