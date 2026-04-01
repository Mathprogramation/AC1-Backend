package com.example.cinema;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.cinema.models.Diretor;
import com.example.cinema.models.Filme;
import com.example.cinema.repositories.DiretorRepository;
import com.example.cinema.repositories.FilmeRepository;

@SpringBootApplication
public class CinemaApplication {
	@Bean
	public CommandLineRunner init(
		@Autowired FilmeRepository filmeRepository,
		@Autowired DiretorRepository diretorRepository
	){
		return args ->{
			System.out.println("***Inserindo Diretores de Filmes***");
			Diretor d1 = new Diretor(null, "Stan Lee", null);
			d1 = diretorRepository.save(d1);

			Diretor d2 = new Diretor(null, "Mel Gibson", null);
			d2 = diretorRepository.save(d2);

			System.out.println("**** Inserindo Filmes ***");
			Filme f1 = new Filme(null, "Homem de Ferro", 120, d1);
			f1 = filmeRepository.save(f1);
			Filme f2 = new Filme(null, "Guerra Civil", 170, d1);
			f2 = filmeRepository.save(f2);
			Filme f3 = new Filme(null, "Até o ultimo Homem", 95, d2);
			f3 = filmeRepository.save(f3);

			List<Filme> duracaoMaior = filmeRepository.findByDuracaoGreaterThan(100);
			System.out.println("*** Filmes com duração maior: ");
			duracaoMaior.stream().map(Filme::getDuracao).forEach(System.out::println);

			List <Filme> duracaoMenor = filmeRepository.findByDuracaoLessThanEqual(150);
			System.out.println("*** Filmes com duração menor: ");
			duracaoMenor.stream().map(Filme::getDuracao).forEach(System.out::println);

			List <Filme> filmes = filmeRepository.findByTituloLike("G%");
			System.out.println("** Filmes que começa com a letra G:  *** ");
			filmes.stream().map(Filme::getTitulo).forEach(System.out::println);


			List <Diretor> diretores = diretorRepository.findByNomeLike("S%");
			System.out.println("Diretor: ");
			diretores.stream().map(Diretor::getNome).forEach(System.out::println);

			List <Diretor> diretoress = diretorRepository.findAll();
				for (Diretor d : diretoress) {
    			System.out.println(d.getId() + " - " + d.getNome() + " qtde filmes: " + d.getFilmess().size());
			}	

		};
	}


	public static void main(String[] args) {
		SpringApplication.run(CinemaApplication.class, args);
	}

}
