package com.example.livro.controller;

import com.example.livro.entity.Livro;
import com.example.livro.enums.Categoria;
import com.example.livro.enums.Modelo;
import com.example.livro.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class LivroController {
    @Autowired
    private LivroRepository livroRepository;

    @ResponseBody
    @RequestMapping("/livros")
    public List<Livro> Listar(){
        Livro livro = new Livro(123L, "Controller - Spring", 1, "Vitor", Categoria.INFORMATICA, Modelo.EBOOK);

        return Arrays.asList(livro, livro, livro);
    }

    @ResponseBody
    @Transactional
    @RequestMapping(path = "/livros", method = RequestMethod.POST)
    public void salvar(@RequestBody Livro livro){
        livroRepository.save(livro);
    }
}
