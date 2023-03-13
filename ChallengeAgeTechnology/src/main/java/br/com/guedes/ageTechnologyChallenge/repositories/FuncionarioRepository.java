package br.com.guedes.ageTechnologyChallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.guedes.ageTechnologyChallenge.Entities.Funcionarios;

public interface FuncionarioRepository extends JpaRepository<Funcionarios, Long>, PagingAndSortingRepository<Funcionarios, Long>{

}
