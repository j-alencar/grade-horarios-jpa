package com.poo.jpa_th_service.repository;

import com.poo.jpa_th_service.entity.Sala;
import com.poo.jpa_th_service.entity.Aula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaRepository extends JpaRepository<Sala, Long> {
    List<Sala> findAllByAula(Aula aula);
}
