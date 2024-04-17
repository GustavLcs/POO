package POO_Homework.List2;

class Elevador {
    private int andarAtual;
    private int totalAndares;
    private int capacidade;
    private int pessoasPresentes;

    public Elevador(int capacidade, int totalAndares) {
        this.capacidade = capacidade;
        this.totalAndares = totalAndares;
        this.andarAtual = 0;
        this.pessoasPresentes = 0;
    }

    public void entrar() {
        if(this.pessoasPresentes < this.capacidade) {
            this.pessoasPresentes++;
        }
    }

    public void sair() {
        if(this.pessoasPresentes > 0) {
            this.pessoasPresentes--;
        }
    }

    public void subir() {
        if(this.andarAtual < this.totalAndares) {
            this.andarAtual++;
        }
    }

    public void descer() {
        if(this.andarAtual > 0) {
            this.andarAtual--;
        }
    }
  
    //gets
    public int getAndarAtual() {
        return this.andarAtual;
    }

    public int getTotalAndares() {
        return this.totalAndares;
    }

    public int getCapacidade() {
        return this.capacidade;
    }

    public int getPessoasPresentes() {
        return this.pessoasPresentes;
    }

    //sets
    public void setAndarAtual(int andarAtual) {
        this.andarAtual = andarAtual;
    }

    public void setTotalAndares(int totalAndares) {
        this.totalAndares = totalAndares;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void setPessoasPresentes(int pessoasPresentes) {
        this.pessoasPresentes = pessoasPresentes;
    }
}