package com.example.atividade1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.atividade1.models.Curso;
import com.example.atividade1.repositories.CursoRepository;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    
    @Autowired
    private CursoRepository cursoRepository;
    
    @PostMapping("/inserir")
    public Curso salvar(@RequestParam String nome) {
        return cursoRepository.salvar(nome);
    }
    
    @GetMapping("/mostrarCursos")
    public List<Curso> mostrarCursos() {
        return cursoRepository.listar();
    }
    
}
