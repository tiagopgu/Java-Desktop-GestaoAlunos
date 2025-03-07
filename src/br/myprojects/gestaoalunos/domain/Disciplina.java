package br.myprojects.gestaoalunos.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Disciplina {
    private float MINIMO_APROVACAO = 7.0F;
    private float MINIMO_RECUPERACAO = 5.0F;
    private float VALOR_ARRENDAMENTO = 0.25F;

    private int codigo;
    private String nome;
    private String descricao;

    private List<Atividade> atividades = new ArrayList<Atividade>();

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public Disciplina(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public void adicionarAtividade(Atividade atividade) {
        atividades.add(atividade);
    }

    public float getNotaFinal() {
        float notaFinal = 0;

        for (Atividade atividade : atividades) notaFinal += atividade.getNotaObtida();

        return notaFinal;
    }

    public String getSituacao() {
        float mediaArredondada = getNotaFinal() + VALOR_ARRENDAMENTO;

        if (getNotaFinal() >= MINIMO_APROVACAO || mediaArredondada >= MINIMO_APROVACAO)
            return "Aprovado";

        if (getNotaFinal() >= MINIMO_RECUPERACAO || mediaArredondada >= MINIMO_RECUPERACAO)
            return "Em Recuperação";

        return "Reprovado";
    }

    public String toString() {
        return "[" + getCodigo() + "] " + getNome() + " - Nota Final: " + getNotaFinal() + " - Situação: " + getSituacao();
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Disciplina other = (Disciplina) obj;

        return Objects.equals(getCodigo(), other.getCodigo());
    }

    public int hashCode() {
        int prime = 11;
        int result = 1;

        result *= prime + Objects.hashCode(getCodigo());

        return result;
    }
}
