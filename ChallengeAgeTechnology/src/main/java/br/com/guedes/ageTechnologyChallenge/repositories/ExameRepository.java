package br.com.guedes.ageTechnologyChallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.guedes.ageTechnologyChallenge.Entities.Exames;

public interface ExameRepository extends JpaRepository<Exames, Long>, PagingAndSortingRepository<Exames, Long>{

}
