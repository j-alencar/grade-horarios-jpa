package com.poo.jpa_th_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;

    @ManyToOne
    private Professor professor;

    @ManyToMany(mappedBy = "disciplinas", fetch = FetchType.EAGER)
    private Set<Curso> cursos = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Turma> turmas;

    public Disciplina(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
        this.turmas = new HashSet<>();
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", professor=" + professor.getNome() +
                '}';
    }
}
