import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tamagotchi{
    // Atributos
    private String nome;
    private int energia;
    private int felicidade;
    private int saude;
    private int fome;
    private LocalDateTime dataDeNascimento;
    private String cicloDeVida;

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
    public void testaSeCresceu(){
        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("mm");
        LocalDateTime agora = LocalDateTime.now();
        String minutoAgora = formatadorData.format(agora);
        String minutoNascimento = formatadorData.format(this.dataDeNascimento);
        int tempoQueDemoraPraCrescer = 1;
        if (this.getCicloDeVida() == "bebe"){
            if (Integer.parseInt(minutoAgora) >= Integer.parseInt(minutoNascimento)+tempoQueDemoraPraCrescer){
                this.cicloDeVida = "adolescente";
            }
        } else if (this.getCicloDeVida() == "adolescente"){
            if (Integer.parseInt(minutoAgora) >= Integer.parseInt(minutoNascimento)+2*tempoQueDemoraPraCrescer){
                this.cicloDeVida = "adulto";
            }
        }
    }

    // Construtor
    public Tamagotchi(String nome){
        this.nome = nome;
        // Os atributos estão em uma escala de 0 a 10
        this.energia = 10;
        this.felicidade = 10;
        this.saude = 10;
        this.fome = 10;
        this.dataDeNascimento = LocalDateTime.now();
        this.cicloDeVida = "bebe";
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
    public String getCicloDeVida(){
        return this.cicloDeVida;
    }
}