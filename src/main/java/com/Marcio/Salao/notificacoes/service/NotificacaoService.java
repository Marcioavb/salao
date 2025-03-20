package com.Marcio.Salao.notificacoes.service;

import com.Marcio.Salao.agendamento.domain.Agendamento;
import com.Marcio.Salao.notificacoes.domain.Notificacao;
import com.Marcio.Salao.notificacoes.util.NotificacaoUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
@Log4j2
public class NotificacaoService {

    private final SimpMessagingTemplate messagingTemplate;

    public NotificacaoService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void enviarNotificacao(Agendamento agendamento, String acao) {
        String mensagem = NotificacaoUtil.formatarMensagemAgendamento(acao, agendamento);

        Notificacao notificacao = new Notificacao(
                mensagem,
                acao.toUpperCase(),
                agendamento.getSalao().getIdSalao(),
                agendamento.getFuncionario().getIdFuncionario(),
                agendamento.getCliente().getIdCliente(),
                agendamento.getStatus().toString(), // Novo campo
                calcularTempoRestante(agendamento.getDataHora()) // Novo campo (opcional)
        );

        // Envia notificação para o salão
        if (notificacao.getIdSalao() != null) {
            messagingTemplate.convertAndSend("/topic/salao/" + notificacao.getIdSalao() + "/notificacoes", notificacao);
            log.info("Notificação enviada para o salão {}: {}", notificacao.getIdSalao(), notificacao.getMensagem());
        }

        // Envia notificação para o funcionário
        if (notificacao.getIdFuncionario() != null) {
            messagingTemplate.convertAndSend("/topic/funcionario/" + notificacao.getIdFuncionario() + "/notificacoes", notificacao);
            log.info("Notificação enviada para o funcionário {}: {}", notificacao.getIdFuncionario(), notificacao.getMensagem());
        }

        // Envia notificação para o cliente
        if (notificacao.getIdCliente() != null) {
            messagingTemplate.convertAndSend("/topic/cliente/" + notificacao.getIdCliente() + "/notificacoes", notificacao);
            log.info("Notificação enviada para o cliente {}: {}", notificacao.getIdCliente(), notificacao.getMensagem());
        }
    }

    private String calcularTempoRestante(LocalDateTime dataHora) {
        Duration duracao = Duration.between(LocalDateTime.now(), dataHora);
        long horas = duracao.toHours();
        long minutos = duracao.toMinutes() % 60;
        return String.format("%d horas e %d minutos", horas, minutos);
    }
}
