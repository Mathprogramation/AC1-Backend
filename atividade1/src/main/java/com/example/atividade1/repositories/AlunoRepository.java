package com.example.atividade1.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.atividade1.models.Aluno;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AlunoRepository {
    @Autowired
    EntityManager entityManager;

    @Transactional
    public Aluno salvar(Aluno aluno){
        return entityManager.merge(aluno);
    }

    public Aluno obterPorId(Long id){
        return entityManager.find(Aluno.class, id);
    }


    public List<Aluno> listar() {
        return entityManager.createQuery(
                "FROM tbl_alunos p", Aluno.class).getResultList();
    }

    @Transactional
    public void delete(Aluno aluno){
         entityManager.remove(aluno);
    }

    @Transactional
    public void editarAlunos(Long id, String novoNome){
        Aluno aluno = entityManager.find(Aluno.class, id);
        if(aluno != null){
            aluno.setNome(novoNome);
            entityManager.merge(aluno);
        }
    }

        


}
