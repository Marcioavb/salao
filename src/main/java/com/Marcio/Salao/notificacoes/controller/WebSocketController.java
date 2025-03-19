package com.Marcio.Salao.notificacoes.controller;

import com.Marcio.Salao.notificacoes.domain.Notificacao;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
@Controller
public class WebSocketController {

    @MessageMapping("/notificacao")
    @SendTo("/topic/notificacoes")
    public Notificacao enviarNotificacao(Notificacao notificacao) {
        // Log para rastrear o recebimento de notificações
        System.out.println("Notificação recebida: " + notificacao.getMensagem());
        return notificacao;

//    @MessageMapping("/notificacao")
//    @SendTo("/topic/notificacoes")
//    public Notificacao enviarNotificacao(Notificacao notificacao) {
//        return notificacao;
    }
}