package br.myprojects.gestaoalunos.application;

import br.myprojects.gestaoalunos.domain.Aluno;
import br.myprojects.gestaoalunos.domain.Atividade;
import br.myprojects.gestaoalunos.domain.Curso;
import br.myprojects.gestaoalunos.domain.Disciplina;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        boolean continuarEntrada = false;
        Aluno alunoAnterior = null;

        do {
            Aluno aluno = obterAluno();

            while (aluno.equals(alunoAnterior)) {
                JOptionPane.showMessageDialog(null, "Aluno já cadastrado", "Aluno duplicado", JOptionPane.WARNING_MESSAGE);

                aluno = obterAluno();
            }

            aluno.setCurso(criarCurso());

            escreverDados(aluno);

            continuarEntrada = JOptionPane.showConfirmDialog(null, "Deseja realizar uma nova entrada?", "Nova entrada", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

            alunoAnterior = aluno;

        } while (continuarEntrada);
    }

    private static Aluno obterAluno() {
        String nome, documento;
        float nota1, nota2, nota3, nota4;

        nome = obterNome();
        documento = obterDocumento();

        return new Aluno(nome, documento);
    }

    private static String obterNome() {
        String nome = null;

        while (nome == null || nome.isBlank()) {
            nome = JOptionPane.showInputDialog(null, "Informe o nome do aluno");

            if (nome == null || nome.isBlank()) {
                JOptionPane.showMessageDialog(null, "Nome deve ser informado");
                continue;
            }

            if (nome.length() < 2) {
                JOptionPane.showMessageDialog(null, "Nome precisa ter no mínimo 2 caracteres");
                nome = "";
            }
        }

        return nome;
    }

    private static String obterDocumento() {
        String documento = null;
        boolean entradaValida = false;

        while (!entradaValida) {
            documento = JOptionPane.showInputDialog(null, "Informe o número do documento");

            entradaValida = documento != null && !documento.isBlank() && documento.length() == 11;

            if (!entradaValida)
                JOptionPane.showMessageDialog(null, "Entrada Inválida. Documento precisa ter 11 dígitos.", "Dados Aluno", JOptionPane.ERROR_MESSAGE);
        }

        return documento;
    }

    private static Curso criarCurso() {
        Curso curso = new Curso(1, "Java e Orientação a Objetos");

        Disciplina disciplina = new Disciplina(1, "Lógica de Programação");
        disciplina.adicionarAtividade(new Atividade(1, "Lista de Exercícios 1", 2F));
        disciplina.adicionarAtividade(new Atividade(2, "Pesquisa Estrutura de Dados", 2F));
        disciplina.adicionarAtividade(new Atividade(3, "Lista de Exercícios 2", 2F));
        disciplina.adicionarAtividade(new Atividade(4, "Exercício Lógica", 1F));
        disciplina.adicionarAtividade(new Atividade(5, "Avaliação Final", 3F));

        curso.adicionarDisciplina(disciplina);

        disciplina = new Disciplina(2, "Orientação a Objetos");
        disciplina.adicionarAtividade(new Atividade(1, "Lista de Exercícios 1", 1.5F));
        disciplina.adicionarAtividade(new Atividade(2, "Pesquisa sobre UML", 2F));
        disciplina.adicionarAtividade(new Atividade(3, "Avaliação", 2F));
        disciplina.adicionarAtividade(new Atividade(4, "Lista de Exercícios 2", 1.5F));
        disciplina.adicionarAtividade(new Atividade(5, "Avaliação Final", 3F));

        curso.adicionarDisciplina(disciplina);

        disciplina = new Disciplina(3, "Arrays");
        disciplina.adicionarAtividade(new Atividade(1, "Lista de Exercícios 1", 3F));
        disciplina.adicionarAtividade(new Atividade(2, "Lista de Exercícios 2", 3F));
        disciplina.adicionarAtividade(new Atividade(3, "Avaliação Final", 4F));

        curso.adicionarDisciplina(disciplina);

        disciplina = new Disciplina(4, "Eclipse");
        disciplina.adicionarAtividade(new Atividade(1, "Atividades Prática", 5F));
        disciplina.adicionarAtividade(new Atividade(2, "Avaliação Final", 5F));

        curso.adicionarDisciplina(disciplina);

        disciplina = new Disciplina(5, "Atributos e Métodos de Classe");
        disciplina.adicionarAtividade(new Atividade(1, "Lista de Exercícios 1", 2.5F));
        disciplina.adicionarAtividade(new Atividade(2, "Lista de Exercícios 2", 2.5F));
        disciplina.adicionarAtividade(new Atividade(3, "Avaliação Final", 5F));

        curso.adicionarDisciplina(disciplina);

        disciplina = new Disciplina(6, "Encapsulamento");
        disciplina.adicionarAtividade(new Atividade(1, "Lista de Exercícios 1", 1.5F));
        disciplina.adicionarAtividade(new Atividade(2, "Avaliação 1", 2F));
        disciplina.adicionarAtividade(new Atividade(3, "Lista de Exercícios 2", 1.5F));
        disciplina.adicionarAtividade(new Atividade(4, "Avaliação Final", 5F));

        curso.adicionarDisciplina(disciplina);

        disciplina = new Disciplina(7, "Herança");
        disciplina.adicionarAtividade(new Atividade(1, "Lista de Exercícios 1", 2.5F));
        disciplina.adicionarAtividade(new Atividade(2, "Lista de Exercícios 2", 2.5F));
        disciplina.adicionarAtividade(new Atividade(3, "Avaliação Final", 5F));

        curso.adicionarDisciplina(disciplina);

        disciplina = new Disciplina(8, "Polimorfismo");
        disciplina.adicionarAtividade(new Atividade(1, "Lista de Exercícios 1", 2F));
        disciplina.adicionarAtividade(new Atividade(2, "Avaliação 1", 2F));
        disciplina.adicionarAtividade(new Atividade(3, "Lista de Exercícios 2", 2F));
        disciplina.adicionarAtividade(new Atividade(4, "Avaliação Final", 4F));

        curso.adicionarDisciplina(disciplina);

        disciplina = new Disciplina(10, "Classes abstratas");
        disciplina.adicionarAtividade(new Atividade(1, "Lista de Exercícios 1", 2F));
        disciplina.adicionarAtividade(new Atividade(2, "Lista de Exercícios 2", 3F));
        disciplina.adicionarAtividade(new Atividade(3, "Avaliação Final", 5F));

        curso.adicionarDisciplina(disciplina);

        return curso;
    }

    private static void escreverDados(Aluno aluno) {
        String saida = aluno +
                "\n     Grade Curricular:";

        for(Disciplina disciplina : aluno.getCurso().getDisciplinas()) {
            saida += "\n        " + disciplina;
        }

        JOptionPane.showMessageDialog(null, saida, "Dados do Aluno", JOptionPane.INFORMATION_MESSAGE);
    }
}