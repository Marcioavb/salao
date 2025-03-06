package com.Marcio.Salao.agendamento.application.api;

import lombok.Getter;
import lombok.ToString;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.UUID;

@ToString
@Getter
public class AgendamentoRequest {

    @NotNull
    @Pattern(regexp = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$",
            message = "ID inválido.")
    @NotNull(message = "ID do cliente é obrigatório")
    private UUID idCliente;

    @NotNull
    @Pattern(regexp = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$",
            message = "ID inválido.")
    @NotNull(message = "ID do funcionário é obrigatório")
    private UUID idFuncionario;

    @NotNull
    @Pattern(regexp = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$",
            message = "ID inválido.")
    @NotNull(message = "ID do serviço é obrigatório")
    private UUID idServico;

    @NotNull(message = "Data e hora são obrigatórias")
    private LocalDateTime dataHora;
}
