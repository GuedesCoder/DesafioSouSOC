package br.com.guedes.ageTechnologyChallenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guedes.ageTechnologyChallenge.DAO.ExamesRealizadosDAO;
import br.com.guedes.ageTechnologyChallenge.entities.ExamesRealizados;

@Service
public class ExamesRealizadosService {

	@Autowired
	private ExamesRealizadosDAO examesRealizadosDAO;

	public void salvar(ExamesRealizados examesRealizados) {
		examesRealizadosDAO.salvar(examesRealizados);
	}

	public void atualizar(ExamesRealizados examesRealizados) {
		examesRealizadosDAO.atualizar(examesRealizados);
	}

	public ExamesRealizados buscarPorId(Long id) {
		return examesRealizadosDAO.buscarPorId(id);
	}

	public List<ExamesRealizados> buscarTodos() {
		return examesRealizadosDAO.buscarTodos();
	}

	public void deletar(Long id) {
		examesRealizadosDAO.deletar(id);
	}
}
