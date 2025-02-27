package com.Marcio.Salao.agendamento.application.api;

import com.Marcio.Salao.agendamento.domain.Agendamento;
import com.Marcio.Salao.agendamento.domain.StatusAgendamento;
import lombok.Getter;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Getter
public class AgendamentoDetalhadoResponse {
    private UUID idAgendamento;
    private String nomeCliente;
    private UUID idCliente;
    private String nomeFuncionario;
    private UUID idFuncionario;
    private String nomeServico;
    private UUID idServico;
    private LocalDateTime dataHora;
    private LocalDateTime dataCriacao;
    private StatusAgendamento status;

    public AgendamentoDetalhadoResponse(Agendamento agendamento) {
        this.idAgendamento = agendamento.getIdAgendamento();
        this.nomeCliente = agendamento.getCliente().getNomeCompleto();
        this.idCliente = agendamento.getCliente().getIdCliente();
        this.nomeFuncionario = agendamento.getFuncionario().getNome();
        this.idFuncionario = agendamento.getFuncionario().getIdFuncionario();
        this.nomeServico = agendamento.getServico().getNomeServico();
        this.idServico = agendamento.getServico().getIdServico();
        this.dataHora = agendamento.getDataHora();
        this.dataCriacao = agendamento.getDataCriacao();
        this.status = agendamento.getStatus();
    }
}
