package com.example.livro.controller;

import com.example.livro.entity.Livro;
import com.example.livro.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LivroController {
    //TODO refatorar

    @Autowired
    private LivroRepository livroRepository;

    @ResponseBody
    @RequestMapping("/livros")
    public List<Livro> Listar(){
        List<Livro> livros = livroRepository.findAll();
        return livros;
    }

    @ResponseBody
    @Transactional
    @RequestMapping(path = "/livros", method = RequestMethod.POST)
    public void salvar(@RequestBody Livro livro){
        livroRepository.save(livro);
    }

    @ResponseBody
    @Transactional
    @RequestMapping(path = "/livros", method = RequestMethod.PUT)
    public void atualizar(@RequestBody Livro livro){
        livroRepository.save(livro);
    }

    @ResponseBody
    @Transactional
    @RequestMapping(path = "/livros/{isbn}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable Long isbn) {
        livroRepository.deleteById(isbn);
    }
}
