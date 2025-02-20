package com.Marcio.Salao.agendamento.domain;

import com.Marcio.Salao.cliente.domain.Cliente;
import com.Marcio.Salao.funcionario.domain.Funcionario;
import com.Marcio.Salao.handler.APIException;
import com.Marcio.Salao.servico.domain.Servico;
import lombok.*;
import org.springframework.http.HttpStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@ToString
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID idAgendamento;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_funcionario", nullable = false)
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "id_servico", nullable = false)
    private Servico servico;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusAgendamento status;

    public Agendamento(Cliente cliente, Funcionario funcionario, Servico servico, LocalDateTime dataHora) {
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.servico = servico;
        this.dataHora = dataHora;
        this.dataCriacao = LocalDateTime.now();
        this.status = StatusAgendamento.CONFIRMADO;
    }

    public void validaDataHora() {
        if (dataHora.isBefore(LocalDateTime.now())) {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Data/hora não pode ser no passado!");
        }
    }
}
