package com.Marcio.Salao.agendamento.infra;

import com.Marcio.Salao.agendamento.domain.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;
import java.util.UUID;

public interface AgendamentoSpringDataJPARepository extends JpaRepository<Agendamento, UUID> {

    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END " +
            "FROM Agendamento a " +
            "WHERE a.funcionario.idFuncionario = :idFuncionario " +
            "AND a.dataHora = :dataHora")
    boolean existsByFuncionarioIdAndDataHora(
            @Param("idFuncionario") UUID idFuncionario,
            @Param("dataHora") LocalDateTime dataHora
    );
}