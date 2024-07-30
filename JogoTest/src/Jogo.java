import java.util.List;

public class Jogo {
  public String dificuldade;
  public List<Personagem> listaPersonagens;
  
  public Jogo(String dificuldade, List<Personagem> listaPersonagens){
    this.dificuldade = dificuldade;
    this.listaPersonagens = listaPersonagens;
  }

  public void adicionarPersonagem(Personagem personagem){
    this.listaPersonagens.add(personagem);
  }

  public void removerPersonagem(Personagem personagem){
    this.listaPersonagens.remove(personagem);
  }

}
