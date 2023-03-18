package br.com.guedes.ageTechnologyChallenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.guedes.ageTechnologyChallenge.entities.ExamesRealizados;
import br.com.guedes.ageTechnologyChallenge.services.ExamesRealizadosService;

@Controller
public class ExamesRealizadosController {

	@Autowired
	private ExamesRealizadosService examesRealizadosService;

	@GetMapping("/listar-examesRealizados")
	public String listarExamesRealizados(Model model) {
		model.addAttribute("examesRealizados", examesRealizadosService.buscarTodos());
		return "listar-examesRealizados";
	}

	@GetMapping("/novo-exameRealizado")
	public String novoExameRealizado(Model model) {
		model.addAttribute("exameRealizado", new ExamesRealizados());
		return "novo-exameRealizado";
	}

	@PostMapping("/salvar-exameRealizado")
	public String salvarExameRealizado(@ModelAttribute("exameRealizado") ExamesRealizados exameRealizado, BindingResult result) {
		if (result.hasErrors()) {
			return "novo-exameRealizado";
		} else {
			examesRealizadosService.salvar(exameRealizado);
			return "redirect:/listar-examesRealizados";
		}
	}

	@GetMapping("/atualizar-exameRealizado/{id}")
	public String atualizarExameRealizado(@PathVariable("id") Long id, Model model) {
		ExamesRealizados exameRealizado = examesRealizadosService.buscarPorId(id);
		model.addAttribute("exameRealizado", exameRealizado);
		return "atualizar-exameRealizado";
	}

	@PostMapping("/atualizar-exameRealizado")
	public String atualizarExameRealizado(@ModelAttribute("exameRealizado") ExamesRealizados exameRealizado, BindingResult result) {
		if (result.hasErrors()) {
			return "atualizar-exameRealizado";
		} else {
			examesRealizadosService.atualizar(exameRealizado);
			return "redirect:/listar-examesRealizados";
		}
	}

	@GetMapping("/deletar-exameRealizado/{id}")
	public String deletarExameRealizado(@PathVariable("id") Long id) {
		examesRealizadosService.deletar(id);
		return "redirect:/listar-examesRealizados";
	}

}
