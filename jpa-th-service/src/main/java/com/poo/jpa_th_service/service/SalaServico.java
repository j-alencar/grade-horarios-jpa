package com.poo.jpa_th_service.service;

import com.poo.jpa_th_service.entity.Aula;
import com.poo.jpa_th_service.entity.Disciplina;
import com.poo.jpa_th_service.entity.Sala;
import com.poo.jpa_th_service.repository.SalaRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaServico {

    @Autowired
    SalaRepository salaRepository;

    public List<Sala> obterTodas() {
        return salaRepository.findAll();
    }

    public List<Sala> obterPorAula(Aula aula) {
        return salaRepository.findAllByAula(aula);
    }

    public Optional<Sala> obterPeloId(long id) {
        return salaRepository.findById(id);
    }

    public void salvar(Sala sala) {
        if(Strings.isBlank(sala.getNome())){
            throw new RuntimeException("Favor informar o nome");
        }
        salaRepository.save(sala);
    }
    public void deletar(Long id) {
        salaRepository.deleteById(id);
    }

}
