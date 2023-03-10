package br.com.guedes.ageTechnologyChallenge.Controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.guedes.ageTechnologyChallenge.Model.Funcionarios;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Controller
public class CadastroDeFuncionariosController {
	@PersistenceContext
	private EntityManager entityManager;
	
	@GetMapping("/Funcionarios")
	public String Funcionarios(Model model)	{
		
		Query query = entityManager.createQuery("select f from db_funcionarios", Funcionarios.class);
		List<Funcionarios> funcionarios = query.getResultList();
		
		return "Funcionarios";
		
	}
	

}
