package br.com.guedes.ageTechnologyChallenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.guedes.ageTechnologyChallenge.entities.ExamesRealizados;
import br.com.guedes.ageTechnologyChallenge.repositories.ExamesRealizadosRepository;

@Service
@Transactional
public class ExamesRealizadosService {

  @Autowired
  private ExamesRealizadosRepository examesRealizadosRepository;

  public List<ExamesRealizados> findAll() {
    return examesRealizadosRepository.findAll();
  }

  public ExamesRealizados findById(Long id) {
    Optional<ExamesRealizados> result = examesRealizadosRepository.findById(id);
    return result.orElseThrow(() -> new RuntimeException("ExamesRealizados not found"));
  }

  public void save(ExamesRealizados examesRealizados) {
    examesRealizadosRepository.save(examesRealizados);
  }

  public void update(Long id, ExamesRealizados examesRealizados) {
    ExamesRealizados entity = examesRealizadosRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("ExamesRealizados not found"));

    entity.setFuncionario(examesRealizados.getFuncionario());
    entity.setDataRealizacao(examesRealizados.getDataRealizacao());

    examesRealizadosRepository.save(entity);
  }

  public void deleteById(Long id) {
    examesRealizadosRepository.deleteById(id);
  }
  
  public List<ExamesRealizados> findByFuncionarioId(Long funcionarioId) {
    return examesRealizadosRepository.findByFuncionarioId(funcionarioId);
  }
  
}
