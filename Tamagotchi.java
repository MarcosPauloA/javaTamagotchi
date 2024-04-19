// Bibliotecas para pegar a data/hora/min/seg e formatar de acordo com a necessidade
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
// Bibliotecas para executar funcoes a cada x segundos
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
// Biblioteca para os eventos aleatorios
import java.util.Random;

public class Tamagotchi{
    // Atributos
    private String nome;
    private float energia;
    private float felicidade;
    private float saude;
    private float fome;
    private LocalDateTime dataDeNascimento;
    private String cicloDeVida;
    private String estadoSaude;

    // Métodos
    public void comer(){
        this.fome += 6;
    }
    public void dormir(){
        this.energia += 6;
    }
    public void cuidar(){
        this.saude += 6;
    }
    public void brincar(){
        this.felicidade += 6;
    }
    public void testaSeCresceu(){
        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("mm");
        LocalDateTime agora = LocalDateTime.now();
        String minutoAgora = formatadorData.format(agora);
        String minutoNascimento = formatadorData.format(this.dataDeNascimento);
        int tempoQueDemoraPraCrescer = 1;
        if (this.getCicloDeVida().equals("bebe")){
            if (Integer.parseInt(minutoAgora) >= Integer.parseInt(minutoNascimento)+tempoQueDemoraPraCrescer){
                this.cicloDeVida = "adolescente";
            }
        } else if (this.getCicloDeVida().equals("adolescente")){
            if (Integer.parseInt(minutoAgora) >= Integer.parseInt(minutoNascimento)+2*tempoQueDemoraPraCrescer){
                this.cicloDeVida = "adulto";
            }
        }
    }
    private Runnable decair = () -> {
        if (this.energia > 0){
            this.energia -= 0.6;
        }
        if (this.felicidade > 0){
            this.felicidade -= 0.4;
        }
        if (this.fome > 0){
            this.fome -= 0.8;
        }
        if (this.saude > 0){
            this.saude -= 0.2;
        }
    };
    public void testaEstadoSaude(){
        if(this.saude <= 4){
            this.estadoSaude = "doente";
        } 
    }

    private Runnable eventoRandomico = () -> {
        Random geradorAleatorio = new Random();
        // Obtem um numero aleatorio entre [0 - 2].
        int n = geradorAleatorio.nextInt(3);
        switch(n){
            case 0:
                System.out.println("Chuva Gelada");
                this.saude -= 1;
                break;
            case 1:
                System.out.println("Sol Quente De Matar");
                this.saude -= 1;
                break;
            case 2:
                System.out.println("Pandemia");
                this.saude -= 1;
        }
    };

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
        this.estadoSaude = "saudavel";
        // Agenda para decair a cada 5 segundos
        ScheduledExecutorService agendador = Executors.newSingleThreadScheduledExecutor();
        agendador.scheduleAtFixedRate(decair, 2, 2, TimeUnit.SECONDS);
        // Agenda para acontecer um evento randomico a cada 30 segundos
        agendador.scheduleAtFixedRate(eventoRandomico, 30, 30, TimeUnit.SECONDS);
    }

    // Getters
    public String getNome(){
        return this.nome;
    }
    public float getEnergia(){
        return this.energia;
    }
    public float getFelicidade(){
        return this.felicidade;
    }
    public float getSaude(){
        return this.saude;
    }
    public float getFome(){
        return this.fome;
    }
    public String getCicloDeVida(){
        return this.cicloDeVida;
    }
    public String getEstadoSaude(){
        return this.estadoSaude;
    }
}