package br.myprojects.gestaoalunos.domain;

import java.util.*;
import java.util.Objects;

public class Curso {
    private int Codigo;
    private String nome;
    private String descricao;

    private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public Curso(int codigo, String nome) {
        Codigo = codigo;
        this.nome = nome;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public void removerDisciplina(int codigo) {
        disciplinas.removeIf(d -> d.getCodigo() == codigo);
    }

    public String toString() {
        return "[" + getCodigo() + "] " + getNome();
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Curso other = (Curso) obj;
        return Objects.equals(getCodigo(), other.getCodigo());
    }

    public int hashCode() {
        int prime = 5;
        int result = 1;

        result *= prime + Objects.hashCode(getCodigo());

        return result;
    }
}
