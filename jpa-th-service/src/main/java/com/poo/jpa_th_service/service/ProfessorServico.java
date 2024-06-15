package com.poo.jpa_th_service.service;

import com.poo.jpa_th_service.entity.Professor;
import com.poo.jpa_th_service.repository.ProfessorRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServico {

    @Autowired
    ProfessorRepository professorRepository;

    public List<Professor> obterTodos() {
        return professorRepository.findAll();
    }

    public Optional<Professor> obterPeloId(long id) {
        return professorRepository.findById(id);
    }
    public void salvar(Professor professor) {
        if(Strings.isBlank(professor.getNome())){
            throw new RuntimeException("Favor informar o nome");
        }
        professorRepository.save(professor);
    }
}

