package br.myprojects.gestaoalunos.domain;

import java.util.Objects;

public class Aluno {
    private String nome;
    private String documento;

    Curso curso;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Aluno(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;
    }

    public String toString() {
        return "Nome: " + getNome() +
                "\nDocumento: " + getDocumento() +
                "\nCurso: " + curso;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Aluno other = (Aluno) obj;

        return Objects.equals(getDocumento(), other.getDocumento());
    }

    public int hashCode() {
        int prime = 37;
        int result = 1;

        result *= prime + Objects.hashCode(getDocumento());

        return result;
    }
}
