package br.com.guedes.ageTechnologyChallenge.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.guedes.ageTechnologyChallenge.entities.ExamesRealizados;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ExamesRealizadosDAO {

	@Autowired
	private EntityManager entityManager;

	public void salvar(ExamesRealizados examesRealizados) {
		entityManager.persist(examesRealizados);
	}

	public void atualizar(ExamesRealizados examesRealizados) {
		entityManager.merge(examesRealizados);
	}

	public ExamesRealizados buscarPorId(Long id) {
		return entityManager.find(ExamesRealizados.class, id);
	}

	public List<ExamesRealizados> buscarTodos() {
		return entityManager.createQuery("SELECT e FROM ExamesRealizados e", ExamesRealizados.class).getResultList();
	}

	public void deletar(Long id) {
		ExamesRealizados examesRealizados = entityManager.find(ExamesRealizados.class, id);
		entityManager.remove(examesRealizados);
	}
}