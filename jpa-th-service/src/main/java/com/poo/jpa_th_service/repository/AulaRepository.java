package com.poo.jpa_th_service.repository;

import com.poo.jpa_th_service.entity.Aula;
import com.poo.jpa_th_service.entity.Disciplina;
import com.poo.jpa_th_service.entity.Professor;
import com.poo.jpa_th_service.entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AulaRepository extends JpaRepository<Aula, Long> {
    List<Aula> findAllByDisciplina(Disciplina disciplina);
    List<Aula> findAllByProfessor(Professor professor);
    List<Aula> findAllByTurma (Turma turma);
}