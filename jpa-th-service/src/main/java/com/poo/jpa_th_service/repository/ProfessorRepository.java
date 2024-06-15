package com.poo.jpa_th_service.repository;

import com.poo.jpa_th_service.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    Optional<Professor> findByNome(String nome);

}
