package com.poo.springjpademo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String nome;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Disciplina> disciplinas;

    public Turma(String nome, Set<Disciplina> disciplinas) {
        this.nome = nome;
        this.disciplinas = disciplinas;
    }

    @Override
    public String toString() {
        StringBuilder disciplinasString = new StringBuilder();
        for (Disciplina disciplina : disciplinas) {
            disciplinasString.append(disciplina.getNome()).append(", "); //Adicionando o nome da disciplina
        }
        return "Turma{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", disciplinas=[" + disciplinasString.toString() + "]" +
                '}';
    }
}
