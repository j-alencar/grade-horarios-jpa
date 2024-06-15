package com.poo.jpa_th_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String horario;

    @Column(nullable = false)
    private String data;

    @Column(nullable = false)
    private String sala;

    @ManyToOne
    private Disciplina disciplina;

    @ManyToOne
    private Professor professor;

    @ManyToOne
    private Turma turma;

    public Aula(String horario, String data, String sala, Disciplina disciplina, Professor professor, Turma turma) {
        this.horario = horario;
        this.data = data;
        this.sala = sala;
        this.disciplina = disciplina;
        this.professor = professor;
        this.turma = turma;
    }

    @Override
    public String toString() {
        return "Aula{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", sala='" + sala + '\'' +
                ", disciplina=" + disciplina.getNome() +
                ", professor=" + professor.getNome() +
                ", turma=" + turma.getNome() +
                '}';
    }

    public Set<String> getCursos() {
        return disciplina.getCursos().stream().map(Curso::getNome).collect(Collectors.toSet());
    }
}
