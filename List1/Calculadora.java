import java.util.Scanner;

public class Calculadora {
  private int valueA;
  private int valueB;
  private char op;

  private boolean testValue(int valueX) {
    if (valueX > 100 || valueX < -100) {
      return false;
    } else {
      return true;
    }
  }

  public boolean testOperator(char op) {
    return op == '*' || op == '-' || op == '+' || op == '/';
  }

  public void getvalueA() {
    System.out.println(valueA);
  }

  public void getvalueB() {
    System.out.println(valueB);
  }

  public void getOperator() {
    System.out.println(op);
  }

  public void setValueA(int valueX){
    this.valueA = valueX;
  }

  public void setvalueB(int valueX){
    this.valueB = valueX;
  }

  public void setOperator(char operator){
    this.op = operator;
  }

  public int calculate() {
    int result = 0;
    switch (op) {
      case '*':
        result = this.valueA * this.valueB;
        break;

      case '/':
        if (valueB != 0) {
          result = this.valueA / this.valueB;
        } else {
          System.out.println("Erro: Divisão por zero.");
        }
        break;

      case '+':
        result = this.valueA + this.valueB;
        break;

      case '-':
        result = this.valueA - this.valueB;
        break;
    }
    return result;

  }

  public void show() {
    System.out.println("O resultado é: ");
    System.out.println(calculate());
  }

  public void captureInformation() {
    boolean primeiraVez = true;
    Scanner scanner = new Scanner(System.in);
    do {
      if (!primeiraVez) {
        System.out.println("Valor inválido");
      }

      System.out.println("Digite o primeiro valor:");
      this.valueA = scanner.nextInt();
      primeiraVez = false;
    } while (!testValue(valueA));
    primeiraVez = true;

    do {
      if (!primeiraVez) {
        System.out.println("Operador inválido");
      }

      System.out.println("Digite o operador:");
      this.op = scanner.next().charAt(0);
      primeiraVez = false;
    } while (!testOperator(op));
    primeiraVez = true;

    do {
      if (!primeiraVez) {
        System.out.println("Valor inválido");
      }

      System.out.println("Digite o segundo valor:");
      this.valueB = scanner.nextInt();
      primeiraVez = false;

    } while (!testValue(valueB));
  }

}
