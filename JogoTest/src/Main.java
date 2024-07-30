import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Personagem> listaPersonagens = new ArrayList<Personagem>();

        Jogo jogo1 = new Jogo("Easy", listaPersonagens);
        Jogavel jogador1 = new Jogavel("Astolfo", 100, jogo1, 3);
        NaoJogavel npc1 = new NaoJogavel("Destroyer of Worlds", 100, jogo1, false);

        jogo1.adicionarPersonagem(jogador1);
        jogo1.adicionarPersonagem(npc1);

        jogador1.botaoA(npc1);
        jogador1.botaoA(npc1);
        jogador1.botaoB(npc1);

        System.out.println(npc1.getVitalidade());
    }
}
