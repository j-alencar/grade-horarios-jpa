package com.poo.jpa_th_service.controllers;

import com.poo.jpa_th_service.entity.Aula;
import com.poo.jpa_th_service.service.AulaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/aula")
public class AulaController {

    @Autowired
    private AulaServico aulaServico;

    @GetMapping("/queryaula")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("aula/queryaula");
        view.addObject("aulas", aulaServico.obterTodos());
        return view;
    }
}
