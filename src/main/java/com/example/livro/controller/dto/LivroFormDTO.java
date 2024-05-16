package com.example.livro.controller.dto;

import com.example.livro.entity.Livro;
import com.example.livro.enums.Categoria;
import com.example.livro.enums.Modelo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LivroFormDTO {
    private Long isbn;
    private String titulo;
    private Integer edicao;
    private String autor;
    private Categoria categoria;
    private Modelo modelo;

    public Livro converter(){
        Livro livro = new Livro();

        livro.setIsbn(isbn);
        livro.setTitulo(titulo);
        livro.setEdicao(edicao);
        livro.setAutor(autor);
        livro.setCategoria(categoria);
        livro.setModelo(modelo);

        return livro;
    }
}
