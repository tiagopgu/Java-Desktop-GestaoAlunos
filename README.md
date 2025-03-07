# Projeto "Gestão de Alunos"

###### _Projeto para prática dos assuntos estudados no curso de Java da JDEV Treinamentos._

## Introdução

O projeto consiste em uma pequena sistema para gerenciar o cadastro de alunos de uma escola. O sistema terá módulos para cadastro e para gerenciamento de notas.

## Regras de negócio

- Cadastro do aluno
  - Dados solicitados
    - Nome, com pelo menos 2 caracteres (obrigatório)
    - Documento, com 11 dígitos (obrigatório)
      - Identifica o aluno
      - Não podem existir dois alunos com o mesmo documento
  - Um aluno estará matriculado em um curso
- Cadastro de curso
  - Dados solicitados
    - Código (obrigatório)
    - Nome (obrigatório)
    - Descrição
  - Possui um conjunto de disciplinas
- Cadastro de disciplina
  - Dados solicitados
    - Código (obrigatório)
    - Nome (obrigatório)
    - Descrição
  - Uma disciplina terá um conjunto de atividades
    - A média final será a soma das notas de todas as atividades
    - A média final deve estar entre 0 e 10
  - Deve ser retornada a situação na disciplina 
    - A situação é analisada com base na média final
      - O sistema calcula uma média auxiliar, somando o valor de _0.25_ à média final. Essa média auxiliar serve para arredondar a nota de um aluno, permitindo mudar sua situação caso falte alguns décimos
    - São possíveis as seguintes situações:
      - _Aprovado_, caso tenha média ou média auxiliar maior ou igual a 7
      - _Em Recuperação_, para média, ou média auxiliar, maior ou igual a 5 e menor que 7
      - _Reprovado_, para média ou média auxiliar menor que 5
- Cadastro de Atividades
  - Dados solicitados
    - Código (obrigatório)
    - Título (obrigatório)
    - Descrição
    - Nota máxima (obrigatório)
    - Nota obtida
- Dados de apresentação
  - Aluno: nome, documento, curso
  - Disciplinas: nome, média (não a média auxiliar) e situação.