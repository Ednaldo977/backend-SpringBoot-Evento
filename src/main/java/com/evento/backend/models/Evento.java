package com.evento.backend.models;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "telefone_id")
    private Telefone telefone;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    // Construtores

    public Evento() {
        // Construtor padrão sem argumentos
    }

    public Evento(String titulo, String descricao, Categoria categoria, Endereco endereco, Telefone telefone) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    // hashCode, equals, toString, etc.

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, descricao, categoria, endereco, telefone);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Evento evento = (Evento) obj;
        return Objects.equals(id, evento.id) &&
                Objects.equals(titulo, evento.titulo) &&
                Objects.equals(descricao, evento.descricao) &&
                Objects.equals(categoria, evento.categoria) &&
                Objects.equals(endereco, evento.endereco) &&
                Objects.equals(telefone, evento.telefone);
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", categoria=" + categoria +
                ", endereco=" + endereco +
                ", telefone=" + telefone +
                '}';
    }
}
