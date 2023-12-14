package com.evento.backend.models;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    // getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Construtores

    public Categoria() {
        // Construtor padrão sem argumentos
    }

    public Categoria(String titulo) {
        this.titulo = titulo;
    }

    // hashCode, equals, toString, etc.

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Categoria categoria = (Categoria) obj;
        return Objects.equals(id, categoria.id) &&
                Objects.equals(titulo, categoria.titulo);
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
