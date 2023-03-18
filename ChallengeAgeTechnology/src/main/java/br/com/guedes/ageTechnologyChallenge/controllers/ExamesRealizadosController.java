package br.com.guedes.ageTechnologyChallenge.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.guedes.ageTechnologyChallenge.entities.Exame;
import br.com.guedes.ageTechnologyChallenge.entities.ExamesRealizados;
import br.com.guedes.ageTechnologyChallenge.services.ExameService;
import br.com.guedes.ageTechnologyChallenge.services.ExamesRealizadosService;
import br.com.guedes.ageTechnologyChallenge.services.FuncionarioService;
import jakarta.validation.Valid;

@Controller
public class ExamesRealizadosController {

    private ExamesRealizadosService examesRealizadosService;
    private ExameService exameService;
    private FuncionarioService funcionarioService;

    public ExamesRealizadosController(ExamesRealizadosService examesRealizadosService, ExameService exameService, FuncionarioService funcionarioService) {
        this.examesRealizadosService = examesRealizadosService;
        this.exameService = exameService;
        this.funcionarioService = funcionarioService;
    }


    @GetMapping("/listar-examesRealizados")
    public String listar(Model model) {
        List<ExamesRealizados> examesRealizados = examesRealizadosService.findAll();
        model.addAttribute("examesRealizados", examesRealizados);
        return "listar-examesRealizados";
    }

    @GetMapping("/ver/{id}")
    public String ver(@PathVariable("id") Long id, Model model) {
        ExamesRealizados examesRealizados = examesRealizadosService.findById(id);
        model.addAttribute("examesRealizados", examesRealizados);
        return "ver-examesRealizados";
    }

    @GetMapping("/novo-exameRealizado")
    public String novoExameRealizado(Model model) {
        model.addAttribute("exameRealizado", new ExamesRealizados());
        model.addAttribute("exames", exameService.listarTodos());
        model.addAttribute("funcionarios", funcionarioService.listarTodos());
        return "novo-exameRealizado";
    }

    @PostMapping("/salvar-exameRealizado")
    public String salvar(@Valid ExamesRealizados examesRealizados, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Exame> exames = exameService.listarTodos();
            model.addAttribute("exames", exames);
            return "novo-exameRealizado";
        }
        examesRealizadosService.save(examesRealizados);
        return "redirect:/listar-examesRealizados";
    }

    @PostMapping("/deletar-exameRealizado/{id}")
    public String deletar(@PathVariable("id") Long id) {
        examesRealizadosService.deleteById(id);
        return "redirect:/listar-examesEealizados";
    }

}
