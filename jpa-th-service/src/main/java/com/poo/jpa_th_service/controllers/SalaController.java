package com.poo.jpa_th_service.controllers;

import com.poo.jpa_th_service.entity.Sala;
import com.poo.jpa_th_service.service.SalaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sala")
public class SalaController {

    @Autowired
    private SalaServico salaServico;

    @GetMapping("/hubsala")
    public String hubSala() {
        return "sala/hubsala";
    }

    @GetMapping("/newsala")
    public ModelAndView mostrarFormularioAdd() {
        ModelAndView modelAndView = new ModelAndView("sala/newsala");
        modelAndView.addObject("sala", new Sala());
        return modelAndView;
    }

    @PostMapping("/newsala")
    public String addSala(@ModelAttribute Sala sala) {
        salaServico.salvar(sala);
        return "redirect:/sala/hubsala";
    }

    @GetMapping("/querysala")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("sala/querysala");
        view.addObject("salas", salaServico.obterTodas());
        return view;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable("id") long id) {
        ModelAndView view = new ModelAndView("sala/editsala");
        var opt = salaServico.obterPeloId(id);
        opt.ifPresent(sala -> view.addObject("sala", sala));
        return view;
    }

    @PostMapping("/atualizar")
    public ModelAndView salvar(@ModelAttribute("sala") Sala sala) {
        try {
            salaServico.salvar(sala);
            return new ModelAndView("redirect:/sala/querysala");
        } catch (Exception e) {
            ModelAndView model = new ModelAndView("sala/editsala");
            model.addObject("erro", e.getMessage());
            model.addObject("sala", sala);
            return model;
        }
    }
}
