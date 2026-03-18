package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Curso;
import com.example.demo.repositories.CursoRepository;

@RestController
public class CursoController {
    
    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping("/cursos")
    public Curso inserir(@RequestBody Curso curso) {
        return cursoRepository.inserir(curso);
    }

    @GetMapping("/cursos")
    public List<Curso> mostrarTodos() {
        return cursoRepository.listar();
    }
}