package POO_Homework.DiceGame;
import java.util.Random;

public class Dado {
  public int face;

  public int jogarDado(){
    Random rand = new Random();
    this.face = rand.nextInt(6) + 1;
    return this.face;
  }

  public int getFace(){
    return this.face;
  }
}