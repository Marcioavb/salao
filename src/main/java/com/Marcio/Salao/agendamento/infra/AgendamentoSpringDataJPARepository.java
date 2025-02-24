package com.Marcio.Salao.agendamento.infra;

import com.Marcio.Salao.agendamento.domain.Agendamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    // Verifica se existe conflito
    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END " +
            "FROM Agendamento a " +
            "WHERE a.funcionario.idFuncionario = :idFuncionario " +
            "AND ( " +
            "   (a.dataHora <= :novaDataHora AND FUNCTION('TIMESTAMPADD', MINUTE, a.servico.duracao, a.dataHora) > " +
            ":novaDataHora) " +
            "   OR " +
            "   (a.dataHora <= FUNCTION('TIMESTAMPADD', MINUTE, :duracaoServico, :novaDataHora) AND FUNCTION('TIMESTAMPADD'" +
            ", MINUTE, a.servico.duracao, a.dataHora) >= :novaDataHora) " +
            ")")
    boolean existsConflitoAgendamento(
            @Param("idFuncionario") UUID idFuncionario,
            @Param("novaDataHora") LocalDateTime novaDataHora,
            @Param("duracaoServico") Integer duracaoServico
    );

    // Busca o agendamento conflitante
    @Query("SELECT a FROM Agendamento a " +
            "WHERE a.funcionario.idFuncionario = :idFuncionario " +
            "AND ( " +
            "(a.dataHora <= :novaDataHora AND a.dataHora + a.servico.duracao * 60 * 1000 > :novaDataHora) " +
            "OR " +
            "(a.dataHora < :novaDataHora + :duracaoServico * 60 * 1000 AND a.dataHora + a.servico.duracao * 60 * 1000 >=" +
            " :novaDataHora + :duracaoServico * 60 * 1000) " +
            "OR " +
            "(a.dataHora >= :novaDataHora AND a.dataHora + a.servico.duracao * 60 * 1000 <= :novaDataHora + :duracaoServico " +
            "* 60 * 1000) " +
            ")")
    Agendamento findConflitoAgendamento(
            @Param("idFuncionario") UUID idFuncionario,
            @Param("novaDataHora") LocalDateTime novaDataHora,
            @Param("duracaoServico") Integer duracaoServico
    );
    Page<Agendamento> findByFuncionarioIdFuncionario(UUID idFuncionario, Pageable pageable);
}