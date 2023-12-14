package com.evento.backend.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "tipofuncao_id")
    private TipoFuncao tipoFuncao;

    // getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public TipoFuncao getTipoFuncao() {
        return tipoFuncao;
    }

    public void setTipoFuncao(TipoFuncao tipoFuncao) {
        this.tipoFuncao = tipoFuncao;
    }

    // Construtores

    public Usuario() {
        // Construtor padrão sem argumentos
    }

    public Usuario(String nome, String email, String telefone, TipoFuncao tipoFuncao) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.tipoFuncao = tipoFuncao;
    }

    // hashCode, equals, toString, etc.

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, telefone, tipoFuncao);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario usuario = (Usuario) obj;
        return Objects.equals(id, usuario.id) &&
                Objects.equals(nome, usuario.nome) &&
                Objects.equals(email, usuario.email) &&
                Objects.equals(telefone, usuario.telefone) &&
                Objects.equals(tipoFuncao, usuario.tipoFuncao);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", tipoFuncao=" + tipoFuncao +
                '}';
    }
}