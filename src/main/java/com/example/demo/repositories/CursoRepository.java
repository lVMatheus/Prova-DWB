package com.example.demo.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Aluno;
import com.example.demo.models.Curso;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CursoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Curso inserir(Curso Curso) {
        return entityManager.merge(Curso);
    }

    public Aluno editar(Aluno Aluno){
        return entityManager.merge(Aluno);
    }

    public List<Curso> listar() {
        return entityManager.createQuery(
                "FROM Curso c", Curso.class).getResultList();
    }

    public Curso buscarPorId(Long id) {
        return entityManager.find(Curso.class, id);
    }

    @Transactional
    public void excluir(Long id) {
        Curso Curso = buscarPorId(id);
        if (Curso != null) {
            entityManager.remove(Curso);
        }
    }
}
