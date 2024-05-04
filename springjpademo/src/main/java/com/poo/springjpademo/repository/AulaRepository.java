package com.poo.springjpademo.repository;

import com.poo.springjpademo.entity.Aula;
import com.poo.springjpademo.entity.Disciplina;
import com.poo.springjpademo.entity.Professor;
import com.poo.springjpademo.entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AulaRepository extends JpaRepository<Aula, Long> {
    List<Aula> findAllByDisciplina(Disciplina Disciplina);
    List<Aula> findAllByProfessor(Professor professor);
    List<Aula> findAllByTurma (Turma turma);
}