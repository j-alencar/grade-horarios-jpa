package com.poo.jpa_th_service.controllers;

import com.poo.jpa_th_service.entity.Disciplina;
import com.poo.jpa_th_service.service.DisciplinaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaServico disciplinaServico;

    @GetMapping("/hubdisciplina")
    public String hubDisciplina() {
        return "disciplina/hubdisciplina";
    }

    @GetMapping("/newdisciplina")
    public ModelAndView mostrarFormularioAdd() {
        ModelAndView modelAndView = new ModelAndView("disciplina/newdisciplina");
        modelAndView.addObject("disciplina", new Disciplina());
        return modelAndView;
    }

    @PostMapping("/newdisciplina")
    public String addDisciplina(@ModelAttribute Disciplina disciplina) {
        disciplinaServico.salvar(disciplina);
        return "redirect:/disciplina/hubdisciplina";
    }

    @GetMapping("/querydisciplina")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("disciplina/querydisciplina");
        view.addObject("disciplinas", disciplinaServico.obterTodos());
        return view;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable("id") long id) {
        ModelAndView view = new ModelAndView("disciplina/editdisciplina");
        var opt = disciplinaServico.obterPeloId(id);
        opt.ifPresent(disciplina -> view.addObject("disciplina", disciplina));
        return view;
    }

    @PostMapping("/atualizar")
    public ModelAndView salvar(@ModelAttribute("disciplina") Disciplina disciplina) {
        try {
            disciplinaServico.salvar(disciplina);
            return new ModelAndView("redirect:/disciplina/querydisciplina");
        } catch (Exception e) {
            ModelAndView model = new ModelAndView("disciplina/editdisciplina");
            model.addObject("erro", e.getMessage());
            model.addObject("disciplina", disciplina);
            return model;
        }
    }
}
