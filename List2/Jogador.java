package POO_Homework.List2;


class Jogador {
    String name;
    String position;
    String birth;
    String nationality;
    float weight;
    float height;
  
    public Jogador(String name, String position, String birth, String nationality, float weight, float height){
      this.name = name;
      this.position = position;
      this.birth = birth;
      this.nationality = nationality;
      this.weight = weight;
      this.height = height;
    }
  
  
  public String getName(){
    return this.name;
  }
  
  public void setName(String name){
    this.name = name;
  }
  
  public String getPosition() {
    return this.position;
  }
  
  public void setPosition(String position){
    this.position = position;
  }  
  
  public String getBirth(){
    return this.birth;
  }
  
  public void setBirth(String birth){
    this.birth = birth;
  }
  
  public String getNationality(){
    return this.nationality;
  }
  
  public void setNationality(String nationality){
    this.nationality = nationality;
  }
  
  public float getWeight(){
    return this.weight;
  }
  
  public void setWeight(float weight){
    this.weight = weight;
  }
  
  public float getHeight(){
    return this.height;
  }
  
  public void setHeight(float height){
    this.height = height;
  }
  
  public void showData(Jogador jogador){
     System.out.println("Nome: " + jogador.getName());
     System.out.println("Posição: " + jogador.getPosition());
     System.out.println("Data de Nascimento: " + jogador.getBirth());
     System.out.println("Nacionalidade: " + jogador.getNationality());
     System.out.println("Peso: " + jogador.getWeight());
     System.out.println("Altura: " + jogador.getHeight());
  }
  
  public int playerAge(){
    int idade = 0;
    String[] data = this.birth.split("/");
    
  }

  public int retiment(){
    int time = 0;
    if(this.position == "Defesa") time = 40 - playerAge();
    if(this.position == "Meio-Campo") time = 38 - playerAge();
    if(this.position == "Ataque") time = 35 - playerAge();
    if(time > 0){
      return time;
    } else {
       System.out.println("Já pode se aposentar");
       return 0;
    }
  }
}
  