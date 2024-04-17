package POO_Homework.List2;


public class Main {
    public static void main(String[] args) {
      
      Jogador jogador1 = new Jogador("Cristiano Ronaldo", "Ataque", "05/02/1985", "Portugal", 80.5, 187.5);
      jogador1.showData(jogador1);
      jogador1.playerAge();
      jogador1.retirement();
    }
  
  }