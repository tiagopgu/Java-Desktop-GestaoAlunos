package br.myprojects.gestaoalunos.domain;

public class Aluno {
    private static float MINIMO_APROVACAO = 7.0F;
    private static float MINIMO_RECUPERACAO = 5.0F;
    private static float VALOR_ARRENDAMENTO = 0.25F;

    String nome;
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

    public Aluno(String nome) {
        this.nome = nome;
    }

    public Aluno(String nome, float nota1, float nota2, float nota3, float nota4) {
        this.nome = nome;
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
}
