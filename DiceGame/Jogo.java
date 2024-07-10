package POO_Homework.DiceGame;
import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {
    public int numJogadores = 1;
    public int resultado;
    public Dado d1 = new Dado();
    public Dado d2 = new Dado();
    ArrayList<String> nomes = new ArrayList<>();
    Scanner s = new Scanner(System.in);

    public void jogarDados(){
        d1.jogarDado();
        d2.jogarDado();
    }

    public void mostrarResultado(){
        setResultado(d1.getFace() + d2.getFace());
        System.out.println("Os dados disseram: "+ getResultado());

    }
    
    public void inserirJogadores(){
        do{
            if(numJogadores < 1 || numJogadores > 11) System.out.println("Número inválido, tente novamente");

            System.out.println("Digite o número de jogadores");
            numJogadores = s.nextInt();
        }while(numJogadores < 1 || numJogadores > 11);
        
        
        for(int i = 0; i <= numJogadores; i++){
            System.out.println("Digite o nome do(a) jogador(a)");
            nomes.add(s.nextLine());
        }
    }

    public void inserirApostas(){
        for(int i = 0; i< numJogadores; i++){
            int numAposta;

            while (true) {
                System.out.print("Senhor(a) " + nomes.get(i) + ", digite o valor que você acredita vencer: ");
                numAposta = s.nextInt();

                if(numAposta >= 2 && numAposta <= 12){
                    break;
                }else{
                    System.out.println("Valor inválido, digite um valor entre 2 e 12");
                }
            }
            this.nomes.set(i, this.nomes.get(i+1) + ", " + numAposta);

        }
    }

    public void setNumJogadores(int numJogadores){
        this.numJogadores = numJogadores;
    }

    public int getNumJogadores(){
        return numJogadores;
    }

    public void setResultado(int resultado){
        this.resultado = resultado;
    }

    public int getResultado(){
        return resultado;
    }

}