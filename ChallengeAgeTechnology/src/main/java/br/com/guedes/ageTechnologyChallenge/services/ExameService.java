package br.com.guedes.ageTechnologyChallenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.guedes.ageTechnologyChallenge.entities.Exame;
import br.com.guedes.ageTechnologyChallenge.repositories.ExameRepository;

@Service
@Transactional
public class ExameService {

    @Autowired
    private ExameRepository exameRepository;

    public List<Exame> listarTodos() {
        return exameRepository.findAll();
    }

    public Exame buscarPorId(Long id) {
        return exameRepository.findById(id).orElse(null);
    }

    public List<Exame> buscarPorNome(String nome) {
        return exameRepository.findByNomeContainingIgnoreCase(nome);
    }

    public Exame salvar(Exame exame) {
        return exameRepository.save(exame);
    }

    public void deletar(Long id) {
        exameRepository.deleteById(id);
    }
}
