package com.Marcio.Salao.agendamento.application.api;

import com.Marcio.Salao.agendamento.domain.Agendamento;
import com.Marcio.Salao.agendamento.domain.StatusAgendamento;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class AgendamentoDetalhadoResponse {
    private UUID idAgendamento;
    private UUID idCliente;
    private UUID idFuncionario;
    private UUID idServico;
    private LocalDateTime dataHora;
    private LocalDateTime dataCriacao;
    private StatusAgendamento status;

    public AgendamentoDetalhadoResponse(Agendamento agendamento) {
        this.idAgendamento = agendamento.getIdAgendamento();
        this.idCliente = agendamento.getCliente().getIdCliente();
        this.idFuncionario = agendamento.getFuncionario().getIdFuncionario();
        this.idServico = agendamento.getServico().getIdServico();
        this.dataHora = agendamento.getDataHora();
        this.dataCriacao = agendamento.getDataCriacao();
        this.status = agendamento.getStatus();
    }
}