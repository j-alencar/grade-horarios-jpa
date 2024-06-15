package com.poo.jpa_th_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    private Aula aula;

    public Sala(String nome, Aula aula) {
        this.nome = nome;
        this.aula = aula;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", aula=" + (aula != null ? aula.getId() : "null") +
                '}';
    }
}
