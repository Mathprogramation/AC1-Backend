package com.example.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.cinema.models.Diretor;
import java.util.List;


public interface DiretorRepository extends JpaRepository<Diretor, Long> {
    
    List <Diretor> findByNomeLike(String nome);

    @Query("select d from Diretor d left join fetch d.filmess f where d.id = :id")
    Diretor findByIdWithFilmes(@Param("id") Long id);




}
