package com.Marcio.Salao.salao.domain;
import com.Marcio.Salao.salao.application.api.SalaoRequest;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Getter
@ToString
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Salao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID idSalao;

    @Column(nullable = false, unique = true)
    private String nomeSalao;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false, unique = true)
    private String telefone;

    private LocalDateTime dataCadastro;

    @Column(nullable = false)
    private LocalTime horarioAbertura;

    @Column(nullable = false)
    private LocalTime horarioFechamento;

    public Salao(SalaoRequest salaoRequest) {
        this.nomeSalao = salaoRequest.getNomeSalao();
        this.endereco = salaoRequest.getEndereco();
        this.telefone = salaoRequest.getTelefone();
        this.dataCadastro = LocalDateTime.now();
        this.horarioAbertura = salaoRequest.getHorarioAbertura();
        this.horarioFechamento = salaoRequest.getHorarioFechamento();
    }
}