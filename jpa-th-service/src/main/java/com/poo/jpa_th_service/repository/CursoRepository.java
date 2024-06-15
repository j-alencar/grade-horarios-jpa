package com.poo.jpa_th_service.repository;

import com.poo.jpa_th_service.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    Curso findByNome(String nome);

}
