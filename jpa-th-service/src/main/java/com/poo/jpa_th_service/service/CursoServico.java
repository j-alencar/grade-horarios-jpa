package com.poo.jpa_th_service.service;

import com.poo.jpa_th_service.entity.Curso;
import com.poo.jpa_th_service.entity.Professor;
import com.poo.jpa_th_service.repository.CursoRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServico {

    @Autowired
    CursoRepository cursoRepository;

    public List<Curso> obterTodos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> obterPeloId(long id) {
        return cursoRepository.findById(id);
    }

    public void salvar(Curso curso) {
        if(Strings.isBlank(curso.getNome())){
            throw new RuntimeException("Favor informar o nome");
        }
        cursoRepository.save(curso);
    }
}