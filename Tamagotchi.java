public class Tamagotchi{
    // Atributos
    private String nome;
    private int energia;
    private int felicidade;
    private int saude;
    private int fome;

    // Métodos
    public void comer(){
        this.fome += 2;
    }
    public void dormir(){
        this.energia += 2;
    }
    public void cuidar(){
        this.saude += 2;
    }
    public void brincar(){
        this.felicidade += 2;
    }

    // Construtor
    public void tamagotchi(String nome){
        this.nome = nome;
        // Os atributos estão em uma escala de 0 a 10
        this.energia = 10;
        this.felicidade = 10;
        this.saude = 10;
        this.fome = 10;
    }

    // Getters
    public String getNome(){
        return this.nome;
    }
    public int getEnergia(){
        return this.energia;
    }
    public int getFelicidade(){
        return this.felicidade;
    }
    public int getSaude(){
        return this.saude;
    }
    public int getFome(){
        return this.fome;
    }
}