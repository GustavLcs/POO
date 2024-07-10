package POO_Homework.DiceGame;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException{
        Jogo jogo = new Jogo();
        jogo.inserirJogadores();
        jogo.inserirApostas();
        jogo.jogarDados();
        jogo.mostrarResultado();
        //to continue
    }

}