package com.example.livro.controller;

import com.example.livro.controller.dto.AtualizaLivroFormDTO;
import com.example.livro.controller.dto.DetalhesLivroDTO;
import com.example.livro.controller.dto.LivroDTO;
import com.example.livro.controller.dto.LivroFormDTO;
import com.example.livro.entity.Livro;
import com.example.livro.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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
    @PutMapping("/{isbn}")
    public DetalhesLivroDTO atualizar(@PathVariable Long isbn, @RequestBody AtualizaLivroFormDTO form){
        final Optional<Livro> optLivro = livroRepository.findById(isbn);

        if (optLivro.isPresent()){
            Livro livro = optLivro.get();
            form.atualiza(livro);
            livroRepository.save(livro);
            return new DetalhesLivroDTO(livro);
        }

        System.out.println("Livro não encontrado");
        return null;
    }

    @Transactional
    @DeleteMapping("/{isbn}")
    public void deletar(@PathVariable Long isbn) {
        final Optional<Livro> optLivro = livroRepository.findById(isbn);

        if (optLivro.isPresent()){
            livroRepository.deleteById(isbn);
        }
    }
}
