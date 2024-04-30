package com.example.livro.controller;

import com.example.livro.entity.Livro;
import com.example.livro.enums.Categoria;
import com.example.livro.enums.Modelo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class LivroController {

    @ResponseBody
    @RequestMapping("/livros")
    public List<Livro> Listar(){
        Livro livro = new Livro(123L, "Controller - Spring", 1, "Vitor", Categoria.INFORMATICA, Modelo.EBOOK);

        return Arrays.asList(livro, livro, livro);
    }
}
