package com.poo.jpa_th_service.controllers;

import com.poo.jpa_th_service.entity.Professor;
import com.poo.jpa_th_service.service.ProfessorServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorServico professorServico;

    @GetMapping("/hubprofessor")
    public String hubProfessor() {
        return "professor/hubprofessor";
    }

    @GetMapping("/newprofessor")
    public ModelAndView mostrarFormularioAdd() {
        ModelAndView modelAndView = new ModelAndView("professor/newprofessor");
        modelAndView.addObject("professor", new Professor());
        return modelAndView;
    }

    @PostMapping("/newprofessor")
    public String addProfessor(@ModelAttribute Professor professor) {
        professorServico.salvar(professor);
        return "redirect:/professor/hubprofessor";
    }

    @GetMapping("/queryprofessor")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("professor/queryprofessor");
        view.addObject("professores", professorServico.obterTodos());
        return view;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable("id") long id) {
        ModelAndView view = new ModelAndView("professor/editprofessor");
        var opt = professorServico.obterPeloId(id);
        opt.ifPresent(professor -> view.addObject("professor", professor));
        return view;
    }

    @PostMapping("/atualizar")
    public ModelAndView salvar(@ModelAttribute("professor") Professor professor) {
        try {
            professorServico.salvar(professor);
            return new ModelAndView("redirect:/professor/queryprofessor");
        } catch (Exception e) {
            ModelAndView model = new ModelAndView("professor/editprofessor");
            model.addObject("erro", e.getMessage());
            model.addObject("professor", professor);
            return model;
        }
    }
}
