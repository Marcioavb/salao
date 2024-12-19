//package com.Marcio.Salao.agendamento.domain;
//
//import com.Marcio.Salao.cliente.domain.Cliente;
//import lombok.*;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//import java.util.UUID;
//
//@Getter
//@ToString
//@Entity
//@Builder
//@NoArgsConstructor(access = AccessLevel.PRIVATE)
//@AllArgsConstructor(access = AccessLevel.PACKAGE)
//public class Agendamento {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
//    private UUID idAgendamento;
//
//    @ManyToOne
//    @JoinColumn(name = "id_cliente", nullable = false)
//    private Cliente cliente;
//
//    @ManyToOne
//    @JoinColumn(name = "id_horario", nullable = false)
//    private HorarioDisponivel horario;
//
//    @Column(nullable = false)
//    private LocalDateTime dataAgendamento;
//}
