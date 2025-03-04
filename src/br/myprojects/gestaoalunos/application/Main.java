package br.myprojects.gestaoalunos.application;

import br.myprojects.gestaoalunos.domain.Aluno;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        boolean continuarEntrada = false;

        do {
            Aluno aluno = obterAluno();

            JOptionPane.showMessageDialog(null, "Aluno: " + aluno.getNome() +
                    "\nMédia: " + aluno.getMedia() +
                    "\nSituação: " + aluno.getSituacao());

            continuarEntrada = JOptionPane.showConfirmDialog(null, "Deseja realizar um novo cálculo?") == JOptionPane.YES_OPTION;

        } while (continuarEntrada);
    }

    private static Aluno obterAluno() {
        String nome;
        float nota1, nota2, nota3, nota4;

        nome = obterNome();
        nota1 = obterNota(1);
        nota2 = obterNota(2);
        nota3 = obterNota(3);
        nota4 = obterNota(4);

        return new Aluno(nome, nota1, nota2, nota3, nota4);
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