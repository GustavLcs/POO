public class Jogavel extends Personagem implements Controle{
  private int nivel;

  public int getNivel() {
    return nivel;
  }
  public void setNivel(int nivel) {
    this.nivel = nivel;
  }

  public Jogavel(String nome, int vitalidade, Jogo jogo, int nivel){
    this.nome = nome;
    this.vitalidade = vitalidade;
    this.jogo = jogo;
    this.nivel = nivel;
  } 

  @Override
  public void aplicarGolpeEspecial(Personagem adversario){
    adversario.vitalidade -= 10 * nivel;
  }

  @Override
  public void botaoA(Personagem personagem){
    aplicarGolpeNormal(personagem);
  }

  @Override
  public void botaoB(Personagem personagem){
    aplicarGolpeEspecial(personagem);
  }
}
