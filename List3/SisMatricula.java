package POO_Homework.List3;

class SisMatricula {
    private String nome;
    private int matricula;
    private float nota1;
    private float nota2;
    private float nota3;
    private float media;
    private String situacao;

    public SisMatricula(String nome, int matricula, float nota1, float nota2, float nota3, float media, String situacao){
        this.nome = nome;
        this.matricula = matricula;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.media = media;
        this.situacao = situacao;
    }

    
    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public void setMatricula(int novaMat) {
        this.matricula = novaMat;
    }

    public void setNotas(float n1, float n2, float n3) {
        this.nota1 = n1;
        this.nota2 = n2;
        this.nota3 = n3;
    }

    public void calcularMedia(){
        this.media = (this.nota1 + this.nota2 + this.nota3)/3;
    }

    public boolean buscarAluno(int matricula){
        
        /* half-way through
        if(this.matricula == matricula){
            System.out.println("Nome: " + this.nome);
            System.out.println("Nota 1: " + this.nota1);
            System.out.println("Nota 2: " + this.nota2);
            System.out.println("Nota 3: " + this.nota3);
            System.out.println("Média: " + this.media);
            System.out.println("Situação: " + this.situacao);
            return true;
        }
        */
    }

    public String getNome() {
        return nome;
    }

    public float getNota1() {
        return nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public float getNota3() {
        return nota3;
    }

    public float getMedia() {
        return media;
    }

    public String getSituacao() {
        return situacao;
    }

    public void alterarNota(int codNota, float valorNota){
        switch (codNota) {
            case 1:
                this.nota1 = valorNota;
                break;
            case 2:
                this.nota2 = valorNota;
                break;
            case 3:
                this.nota3 = valorNota;
            default:
                System.out.println("Código incorreto");

                break;
        }
    }

}
