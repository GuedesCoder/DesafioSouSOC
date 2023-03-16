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

import br.com.guedes.ageTechnologyChallenge.entities.Funcionario;
import br.com.guedes.ageTechnologyChallenge.services.FuncionarioService;
import jakarta.validation.Valid;

@Controller
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;
    
    @GetMapping("/listar-funcionarios")
    public String listar(Model model) {
        List<Funcionario> funcionarios = funcionarioService.listarTodos();
        model.addAttribute("funcionarios", funcionarios);
        return "listar-funcionarios";
    }

    @GetMapping("/novo-funcionario")
    public String novo(Model model) {
        Funcionario funcionario = new Funcionario();
        model.addAttribute("funcionario", funcionario);
        return "novo-funcionario";
    }

    @GetMapping("/atualizar-funcionario/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        Funcionario funcionario = funcionarioService.buscarPorId(id);
        model.addAttribute("funcionario", funcionario);
        return "atualizar-funcionario";
    }
    
    @PostMapping("/atualizar-funcionario")
    public String salvarFuncionarioAtualizado(@Valid Funcionario funcionario, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/atualizar-funcionario";
        }

        funcionarioService.salvar(funcionario);
        return "redirect:/listar-funcionarios";
    }

    @PostMapping("/salvar-funcionario")
    public String salvar(@ModelAttribute("funcionario") Funcionario funcionario) {
        funcionarioService.salvar(funcionario);
        return "redirect:/listar-funcionarios";
    }

    @GetMapping("/deletar-funcionario/{id}")
    public String excluir(@PathVariable("id") Long id) {
        funcionarioService.excluir(id);
        return "redirect:/listar-funcionarios";
    }
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
