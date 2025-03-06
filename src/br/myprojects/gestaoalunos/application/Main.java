package br.myprojects.gestaoalunos.application;

import br.myprojects.gestaoalunos.domain.Aluno;

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

            JOptionPane.showMessageDialog(null, aluno, "Dados do Aluno", JOptionPane.INFORMATION_MESSAGE);

            continuarEntrada = JOptionPane.showConfirmDialog(null, "Deseja realizar uma nova entrada?", "Nova entrada", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

            alunoAnterior = aluno;

        } while (continuarEntrada);
    }

    private static Aluno obterAluno() {
        String nome, documento;
        float nota1, nota2, nota3, nota4;

        nome = obterNome();
        documento = obterDocumento();
        nota1 = obterNota(1);
        nota2 = obterNota(2);
        nota3 = obterNota(3);
        nota4 = obterNota(4);

        return new Aluno(nome, documento, nota1, nota2, nota3, nota4);
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

    private static float obterNota(int bimestre) {
        float nota = -1F;

        while (nota < 0 || nota > 10) {
            nota = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe a nota do " + bimestre + "º bimestre"));

            if (nota < 0 || nota > 10) {
                JOptionPane.showMessageDialog(null, "A nota deve estar entre 0 e 10");
            }
        }

        return nota;
    }
}