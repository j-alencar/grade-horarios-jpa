package com.poo.jpa_th_service.repository;

import com.poo.jpa_th_service.entity.Disciplina;
import com.poo.jpa_th_service.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

    List<Disciplina> findAllByProfessor(Professor professor);

    Disciplina findByNome(String nome);
}
