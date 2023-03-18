package br.com.guedes.ageTechnologyChallenge.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.com.guedes.ageTechnologyChallenge.entities.ExamesRealizados;

@Transactional
public interface ExamesRealizadosRepository extends JpaRepository<ExamesRealizados, Long> {

  @Query("SELECT er FROM ExamesRealizados er WHERE er.funcionario.id = :funcionarioId")
  List<ExamesRealizados> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId);

}
