
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    int op;
    do {
      System.out.println("-----------------------");
      System.out.println("MENU PRINCIPAL");
      System.out.println("-----------------------");
      System.out.println("1 - CADASTRAR ALUNOS");
      System.out.println("2 - CADASTRAR NOTAS");
      System.out.println("3 - CALCULAR MÉDIAS");
      System.out.println("4 - INFORMAR SITUAÇÕES");
      System.out.println("5 - INFORMAR DADOS DE UM ALUNO");
      System.out.println("6 - ALTERAR NOTA");
      System.out.println("7 - SAIR");

      // System.out.println(alunos.size());
      op = reader.nextInt();
      switch (op) {
        case 1: {
          for (int i = 0; i < 3; i++) {
            Aluno al = new Aluno();
            System.out.print("Nome: ");
            al.setNome(reader.nextLine());
            if (i == 0)
              reader.nextLine();
            System.out.print("Matrícula: ");
            al.setMatricula(Integer.parseInt(reader.nextLine()));
            al.add(al);
          }

        }
          break;

        case 2: {
          Float nota1, nota2, nota3;
          int i = 0;
          for (Aluno al : Aluno) {
            System.out.println("Notas 1, 2 e 3 de " + al.getNome() + ":");
            if (i == 0)
              reader.nextLine();
            nota1 = Float.parseFloat(reader.nextLine());
            nota2 = Float.parseFloat(reader.nextLine());
            nota3 = Float.parseFloat(reader.nextLine());
            al.setNotas(nota1, nota2, nota3);
            i++;
          }
          break;
        }
        case 3: {
          for (Aluno al : Aluno) {
            al.calcularMedia();
            System.out.println(al.getMedia());
          }
          break;
        }
        case 4: {
          for (Aluno al : Aluno) {
            al.getSituacao();
            System.out.println(al.getNome() + " possui a média: " + al.getMedia() + ", ele está " + al.getSituacao());
          }
          break;
        }
        case 5: {
          System.out.flush();
          boolean found = false;
          System.out.println("Informe a matricula: ");
          reader.nextLine();
          for (Aluno al : alunos) {
            if (al.buscarAluno(Integer.parseInt(reader.nextLine())) && !found) {
              System.out.println("Nome = " + nome + ", matrícula = " + matricula + ", nota1 = " + nota1 + ", nota2 = " + nota2 + ", nota3 = " + nota3 + ", média = " + media + ", situação = " + situacao + ".");
              found = true;
              break;
            }
          }
          if (!found)
            System.out.println("Estudante não encontrado...");
          break;
        }
        case 6: {
          boolean found = false;
          System.out.println("Informe a matricula: ");
          reader.nextLine();
          for (Aluno al : Aluno) {
            if (al.buscarAluno(Integer.parseInt(reader.nextLine())) && !found) {
                System.out.println("Nome = " + nome + ", matrícula = " + matricula + ", nota1 = " + nota1 + ", nota2 = " + nota2 + ", nota3 = " + nota3 + ", média = " + media + ", situação = " + situacao + ".");
              System.out.println("Digite qual nota alterar(1,2 ou 3) e seu novo valor");
              al.alterarNota(Integer.parseInt(reader.nextLine()), Float.parseFloat(reader.nextLine()));
              al.getSituacao();
              System.out.println(al.getNome() + " com média: " + al.getMedia() + " está " + al.getSituacao());
              found = true;
              break;
            }
          }
          if (!found)
            System.out.println("Estudante nao encontrado(a)...");
          break;
        }
      }
    } while (op != 7);
  }
}
