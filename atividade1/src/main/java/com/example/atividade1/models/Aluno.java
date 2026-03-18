package com.example.atividade1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="tbl_alunos")
public class Aluno {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(nullable=false)
    private String nome;

    private int anoIngresso;

    @ManyToOne()
    @JoinColumn(name="id_curso")
    private Curso curso;
    
    public Aluno() {
    }

    public Aluno(Long id, String nome, int anoIngresso, Curso curso) {
        this.id = id;
        this.nome = nome;
        this.anoIngresso = anoIngresso;
        this.curso = curso;
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
    public int getAnoIngresso() {
        return anoIngresso;
    }
    public void setAnoIngresso(int anoIngresso) {
        this.anoIngresso = anoIngresso;
    }
    
    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Aluno [id=" + id + ", nome=" + nome + ", anoIngresso=" + anoIngresso + ", curso=" + curso + "]";
    }
    
}
