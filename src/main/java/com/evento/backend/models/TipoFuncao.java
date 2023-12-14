package com.evento.backend.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class TipoFuncao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String funcao;

    // Construtores

    public TipoFuncao() {
        // Construtor padrão sem argumentos
    }

    public TipoFuncao(String funcao) {
        this.funcao = funcao;
    }

    // getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    // hashCode, equals, toString, etc.

    @Override
    public int hashCode() {
        return Objects.hash(id, funcao);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TipoFuncao tipoFuncao = (TipoFuncao) obj;
        return Objects.equals(id, tipoFuncao.id) &&
                Objects.equals(funcao, tipoFuncao.funcao);
    }

    @Override
    public String toString() {
        return "TipoFuncao{" +
                "id=" + id +
                ", funcao='" + funcao + '\'' +
                '}';
    }
}
