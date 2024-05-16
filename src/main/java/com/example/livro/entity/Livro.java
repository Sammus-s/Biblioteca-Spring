package com.example.livro.entity;

import com.example.livro.enums.Categoria;
import com.example.livro.enums.Modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Livro {
    @Id
    private Long isbn;
    private String titulo;
    private Integer edicao;
    private String autor;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    @Enumerated(EnumType.STRING)
    private Modelo modelo;

}
