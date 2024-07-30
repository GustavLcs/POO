public abstract class Personagem {
  public String nome;
  public int vitalidade;
  public Jogo jogo;

  public Jogo getJogo() {
    return jogo;
  }
  public String getNome() {
    return nome;
  }
  public int getVitalidade() {
    return vitalidade;
  }
  public void setJogo(Jogo jogo) {
    this.jogo = jogo;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public void setVitalidade(int vitalidade) {
    this.vitalidade = vitalidade;
  }

  public void aplicarGolpeNormal(Personagem adversario){
    adversario.vitalidade -= 10;
  }

  public abstract void aplicarGolpeEspecial(Personagem adversario);
}
