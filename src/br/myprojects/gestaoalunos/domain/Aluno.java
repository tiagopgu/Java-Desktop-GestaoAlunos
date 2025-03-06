package br.myprojects.gestaoalunos.domain;

import java.util.Objects;

public class Aluno {
    private static float MINIMO_APROVACAO = 7.0F;
    private static float MINIMO_RECUPERACAO = 5.0F;
    private static float VALOR_ARRENDAMENTO = 0.25F;

    String nome;
    String documento;

    float nota1;
    float nota2;
    float nota3;
    float nota4;

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

    public float getNota1() {
        return nota1;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    public float getNota3() {
        return nota3;
    }

    public void setNota3(float nota3) {
        this.nota3 = nota3;
    }

    public float getNota4() {
        return nota4;
    }

    public void setNota4(float nota4) {
        this.nota4 = nota4;
    }

    public Aluno(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;
    }

    public Aluno(String nome, String documento, float nota1, float nota2, float nota3, float nota4) {
        this.nome = nome;
        this.documento = documento;

        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
    }

    public float getMedia() {
        return (nota1 + nota2 + nota3 + nota4) / 4;
    }

    public String getSituacao() {
        float mediaArredondada = getMedia() + VALOR_ARRENDAMENTO;

        if (getMedia() >= MINIMO_APROVACAO || mediaArredondada >= MINIMO_APROVACAO)
            return "Aprovado";

        if (getMedia() >= MINIMO_RECUPERACAO || mediaArredondada >= MINIMO_RECUPERACAO)
            return "Em Recuperação";

        return "Reprovado";
    }

    public String toString() {
        return "Nome: " + getNome() +
                "\nDocumento: " + getDocumento() +
                "\nMédia: " + getMedia() +
                "\nSituação: " + getSituacao();
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
