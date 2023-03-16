
package br.com.guedes.ageTechnologyChallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.guedes.ageTechnologyChallenge.entities.Exame;
import br.com.guedes.ageTechnologyChallenge.services.ExameService;
import jakarta.validation.Valid;

@Controller
public class ExameController {

	@Autowired
	private ExameService exameService;

	@GetMapping("/listar-exames")
	public String listar(Model model) {
		List<Exame> exames = exameService.listarTodos();
		model.addAttribute("exames", exames);
		return "listar-exames";
	}

	@GetMapping("/novo-exame")
	public String novo(Model model) {
		Exame exame = new Exame();
		model.addAttribute("exame", exame);
		return "novo-exame";
	}

	@GetMapping("/atualizar-exame/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		Exame exame = exameService.buscarPorId(id);
		model.addAttribute("exame", exame);
		return "atualizar-exame";
	}
	
	@PostMapping("/atualizar-exame")
    public String salvarExameAtualizado(@Valid Exame exame, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/atualizar-exame";
        }

        exameService.salvar(exame);
        return "redirect:/listar-exames";
    }

	@PostMapping("/salvar-exame")
	public String salvar(@ModelAttribute("exame") Exame exame) {
		exameService.salvar(exame);
		return "redirect:/listar-exames";
	}

	@GetMapping("/deletar-exame/{id}")
	public String excluir(@PathVariable("id") Long id) {
		exameService.excluir(id);
		return "redirect:/listar-exames";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
}
