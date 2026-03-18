package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.models.Aluno;
import com.example.demo.models.Curso;
import com.example.demo.repositories.AlunoRepository;
import com.example.demo.repositories.CursoRepository;

@SpringBootApplication
public class exemploApplication {

	@Bean
	public CommandLineRunner init(
			@Autowired AlunoRepository AlunoRepository,
			@Autowired CursoRepository CursoRepository) {
		return args -> {
			Curso c1 = CursoRepository.inserir(
					new Curso(null, "Engenharia de Pesca"));

			AlunoRepository.inserir(
					new Aluno(null, "Matheusão", c1, 2020));

			Curso c2 = CursoRepository.inserir(
			new Curso(null, "Engenharia de Alimentos"));

			AlunoRepository.inserir(
					new Aluno(null, "Chef Jacquin", c2, 2023));

			List<Aluno> listaAlunos = AlunoRepository.listar();
			listaAlunos.forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(exemploApplication.class, args);
	}

}
