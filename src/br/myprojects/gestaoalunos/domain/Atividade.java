package br.myprojects.gestaoalunos.domain;

import java.util.Objects;

public class Atividade {
    private int codigo;
    private String titulo;
    private String descricao;

    private float notaMaxima;
    private float notaObtida;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public float getNotaMaxima() {
        return notaMaxima;
    }

    public void setNotaMaxima(float notaMaxima) {
        this.notaMaxima = notaMaxima;
    }

    public float getNotaObtida() {
        return notaObtida;
    }

    public void setNotaObtida(float notaObtida) {
        this.notaObtida = notaObtida;
    }

    public Atividade(int codigo, String titulo, float notaMaxima) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.notaMaxima = notaMaxima;
    }

    public String toString() {
        return "[" + getCodigo() + "] " + getTitulo() + " - Nota Obtida: " + getNotaObtida();
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Atividade other = (Atividade) obj;

        return Objects.equals(getCodigo(), other.getCodigo());
    }

    public int hashCode() {
        int prime = 2;
        int result = 1;

        result *= prime + Objects.hashCode(getCodigo());

        return result;
    }
}
