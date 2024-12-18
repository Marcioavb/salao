package com.Marcio.Salao.cliente.domain;

import com.Marcio.Salao.cliente.apllication.api.ClienteRequest;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@ToString
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Cliente {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID idCliente;
    @NotBlank
    private String nomeCompleto;
    @NotBlank
    private String telefone;
    private LocalDateTime dataCadastro;

    public Cliente(ClienteRequest clienteRequest) {
        this.nomeCompleto = clienteRequest.getNomeCompleto();
        this.telefone = clienteRequest.getTelefone();
        this.dataCadastro = LocalDateTime.now();
    }
}
