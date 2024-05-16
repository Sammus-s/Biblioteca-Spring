package com.example.livro.controller;

import com.example.livro.controller.dto.LivroDTO;
import com.example.livro.controller.dto.LivroFormDTO;
import com.example.livro.entity.Livro;
import com.example.livro.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public List<LivroDTO> Listar(){
        List<Livro> livros = livroRepository.findAll();
        return LivroDTO.converter(livros);
    }

    @Transactional
    @PostMapping
    public LivroDTO salvar(@RequestBody LivroFormDTO form){
        Livro livro = form.converter();
        livroRepository.save(livro);
        return new LivroDTO(livro);
    }

    @Transactional
    @PutMapping
    public void atualizar(@RequestBody Livro livro){
        livroRepository.save(livro);
    }

    @Transactional
    @DeleteMapping
    public void deletar(@PathVariable Long isbn) {
        livroRepository.deleteById(isbn);
    }
}
