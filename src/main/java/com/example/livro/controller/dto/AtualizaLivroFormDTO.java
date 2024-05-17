package com.example.livro.controller.dto;

import com.example.livro.entity.Livro;
import com.example.livro.enums.Categoria;
import com.example.livro.enums.Modelo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AtualizaLivroFormDTO {
    private String categoria;
    private String modelo;

    public void atualiza(Livro livro){
        livro.setCategoria(Categoria.valueOf(categoria));
        livro.setModelo(Modelo.valueOf(modelo));
    }
}
