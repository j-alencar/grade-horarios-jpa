package com.poo.jpa_th_service.repository;
import com.poo.jpa_th_service.entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<Turma, Long> {

    Turma findByNome(String nome);
}
