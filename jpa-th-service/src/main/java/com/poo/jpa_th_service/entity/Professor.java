package com.poo.jpa_th_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private boolean isAusente;

    public Professor(String nome, boolean isAusente) {
        this.nome = nome;
        this.isAusente = isAusente;
    }

    public boolean isAusente() {
        return isAusente;
    }

    public void setAusente(boolean isAusente) {
        this.isAusente = isAusente;
    }
}
