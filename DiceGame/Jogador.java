package POO_Homework.DiceGame;

public class Jogador {
  private String nome;
  private int aposta;


  public Jogador(String nome, int aposta) {
    this.nome = nome;
    this.aposta = aposta;
  }

  public String getNome() {
    return this.nome;
  }

  public int getAposta() {
    return this.aposta;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setAposta(int aposta) {
    this.aposta = aposta;
  }
}