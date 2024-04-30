package com.example.livro.entity;

import com.example.livro.enums.Categoria;
import com.example.livro.enums.Modelo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Livro {
    private Long isbn;
    private String titulo;
    private Integer edicao;
    private String autor;
    private Categoria categoria;
    private Modelo modelo;


}
