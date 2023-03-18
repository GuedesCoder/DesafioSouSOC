package br.com.guedes.ageTechnologyChallenge.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.guedes.ageTechnologyChallenge.entities.ExamesRealizados;

public interface ExamesRealizadosRepository extends JpaRepository<ExamesRealizados, Long> {
    	
    List<ExamesRealizados> findAllByFuncionarioId(Long funcionarioId);

    List<ExamesRealizados> findAllByExameId(Long exameId);

    List<ExamesRealizados> findAllByDataRealizacaoBetween(Date dataInicial, Date dataFinal);
	
    List<ExamesRealizados> findByFuncionarioNomeContainingIgnoreCase(String nomeFuncionario);

}
