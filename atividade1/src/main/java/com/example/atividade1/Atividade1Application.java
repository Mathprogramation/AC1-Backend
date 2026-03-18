package com.example.atividade1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.atividade1.models.Aluno;
import com.example.atividade1.models.Curso;
import com.example.atividade1.repositories.AlunoRepository;
import com.example.atividade1.repositories.CursoRepository;




@SpringBootApplication
public class Atividade1Application {
	@Bean
	public CommandLineRunner init(
		@Autowired AlunoRepository alunoRepository,
		@Autowired CursoRepository cursoRepository){
			Curso c1 = cursoRepository.salvar("ADS");
			Curso c2 = cursoRepository.salvar("Enfermagem");
	 
		return args -> {
			alunoRepository.salvar(new Aluno(null, "Lucas", 2026, c1));
			alunoRepository.salvar(new Aluno(null, "Maria", 2027, c2));
			
			List<Aluno> listaAlunos = alunoRepository.listar();
			listaAlunos.forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Atividade1Application.class, args);
	}

}
