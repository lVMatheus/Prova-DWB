package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_alunos")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int anoIngresso;
    @ManyToOne
    @JoinColumn(name = "idCurso")
    private Curso curso;

    public Aluno(Long id, String nome, Curso idCurso, int anoIngresso) {
        this.id = id;
        this.nome = nome;
        this.curso = idCurso;
        this.anoIngresso = anoIngresso;
    }

    public Aluno() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso getIdCurso() {
        return curso;
    }

    public void setIdCurso(Curso idCurso) {
        this.curso = idCurso;
    }

    public int getAnoIngresso() {
    return anoIngresso;
    }

    public void setaAnoIngresso(int anoIngresso) {
        this.anoIngresso = anoIngresso;
    }

    @Override
    public String toString() {
        return "Aluno [id=" + id + ", nome=" + nome + ", Curso=" + this.curso.getNome() + "]";
    }
}

