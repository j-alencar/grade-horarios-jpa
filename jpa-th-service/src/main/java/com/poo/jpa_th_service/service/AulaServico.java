package com.poo.jpa_th_service.service;

import com.poo.jpa_th_service.entity.Aula;
import com.poo.jpa_th_service.repository.AulaRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AulaServico {

    @Autowired
    AulaRepository aulaRepository;

    public List<Aula> obterTodos() {
        return aulaRepository.findAll();
    }
    public Optional<Aula> obterPeloId(long id) {
        return aulaRepository.findById(id);
    }
}


