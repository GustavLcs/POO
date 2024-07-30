public class NaoJogavel extends Personagem {
  private boolean aliado;

  public NaoJogavel(String nome, int vitalidade, Jogo jogo, boolean aliado){
    this.nome = nome;
    this.vitalidade = vitalidade;
    this.jogo = jogo;
    this.aliado = aliado;
  }

  public boolean getAliado(){
    return aliado;
  }
  public boolean setAliado(boolean aliado){
    return this.aliado = aliado;
  }

  @Override
  public void aplicarGolpeEspecial(Personagem adversario) {
    if(this.jogo.dificuldade == "Easy"){
      adversario.vitalidade -= 20;
    }else if(this.jogo.dificuldade == "Medium"){
      adversario.vitalidade -= 30;
    }else{
      adversario.vitalidade -= 40;
    }
  }
}
