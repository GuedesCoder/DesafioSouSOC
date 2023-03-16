package br.com.guedes.ageTechnologyChallenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guedes.ageTechnologyChallenge.entities.Exame;
import br.com.guedes.ageTechnologyChallenge.repositories.ExameRepository;

@Service
public class ExameService {
	
	@Autowired
	private ExameRepository exameRepository;
	
	public List<Exame> listarTodos() {
		return exameRepository.findAll();
	}
	
	public Exame salvar(Exame exame) {
		return exameRepository.save(exame);
	}
	
	public void excluir(Long id) {
		exameRepository.deleteById(id);
	}
	
	public Exame buscarPorId(Long id) {
		return exameRepository.findById(id).orElse(null);
	}
	
	public List<Exame> buscarPorNome(String nome) {
		return exameRepository.findByNomeContainingIgnoreCase(nome);
	}
}
