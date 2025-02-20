package com.Marcio.Salao.agendamento.application.api;

import lombok.Getter;
import lombok.ToString;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@ToString
@Getter
public class AgendamentoRequest {
    @NotNull(message = "ID do cliente é obrigatório")
    private UUID idCliente;

    @NotNull(message = "ID do funcionário é obrigatório")
    private UUID idFuncionario;

    @NotNull(message = "ID do serviço é obrigatório")
    private UUID idServico;

    @NotNull(message = "Data e hora são obrigatórias")
    private LocalDateTime dataHora;
}
