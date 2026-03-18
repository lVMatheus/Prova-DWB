package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repositories.CursoRepository;

@RestController
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    PostMapping("/cursos")
    
}
