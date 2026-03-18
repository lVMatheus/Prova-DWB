package com.example.demo.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Aluno;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AlunoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Aluno inserir(Aluno Aluno) {
        return entityManager.merge(Aluno);
    }

    public Aluno editar(Aluno Aluno){
        return entityManager.merge(Aluno);
    }

    public List<Aluno> listar() {
        return entityManager.createQuery(
                "FROM Aluno a", Aluno.class).getResultList();
    }

    public Aluno buscarPorId(Long id) {
        return entityManager.find(Aluno.class, id);
    }

    @Transactional
    public void excluir(Long id) {
        Aluno Aluno = buscarPorId(id);
        if (Aluno != null) {
            entityManager.remove(Aluno);
        }
    }
}
