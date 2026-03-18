package com.example.atividade1.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.atividade1.models.Curso;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CursoRepository {
    @Autowired
    EntityManager entityManager;

    @Transactional
    public Curso salvar(String nome){
        Curso curso = new Curso(null, nome);
        return entityManager.merge(curso);
    }

    public List<Curso> listar() {
        return entityManager.createQuery(
                "FROM Curso", Curso.class).getResultList();
    }

    public Curso obterPorId(Long id){
        return entityManager.find(Curso.class, id);
    }

    @Transactional
    public void delete(Curso curso){
         entityManager.remove(curso);
    }


}
