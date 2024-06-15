package com.poo.jpa_th_service.controllers;

import com.poo.jpa_th_service.entity.Curso;
import com.poo.jpa_th_service.service.CursoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoServico cursoServico;

    @GetMapping("/hubcurso")
    public String hubCurso() {
        return "curso/hubcurso";
    }

    @GetMapping("/newcurso")
    public ModelAndView mostrarFormularioAdd() {
        ModelAndView modelAndView = new ModelAndView("curso/newcurso");
        modelAndView.addObject("curso", new Curso());
        return modelAndView;
    }

    @PostMapping("/newcurso")
    public String addCurso(@ModelAttribute Curso curso) {
        cursoServico.salvar(curso);
        return "redirect:/curso/hubcurso";
    }

    @GetMapping("/querycurso")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("curso/querycurso");
        view.addObject("cursos", cursoServico.obterTodos());
        return view;
    }


    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable("id") long id) {
        ModelAndView view = new ModelAndView("curso/editcurso");
        var opt = cursoServico.obterPeloId(id);
        opt.ifPresent(curso -> view.addObject("curso", curso));
        return view;
    }

    @PostMapping("/atualizar")
    public ModelAndView salvar(@ModelAttribute("curso") Curso curso) {
        try {
            cursoServico.salvar(curso);
            return new ModelAndView("redirect:/curso/querycurso");
        } catch (Exception e) {
            ModelAndView model = new ModelAndView("curso/editcurso");
            model.addObject("erro", e.getMessage());
            model.addObject("curso", curso);
            return model;
        }
    }
}
