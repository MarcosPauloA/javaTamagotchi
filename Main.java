// Arquivo para testes da classe

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome de seu Tamagothi");
        String nome = sc.nextLine();
        

        Tamagotchi teste = new Tamagotchi(nome);

        System.out.println("O nome de seu tamagotchi é " + teste.getNome());

        while (true) {
            teste.testaSeCresceu();
            mostraComandos();
            int comando = sc.nextInt();

            switch(comando){
                case 0:
                    System.out.println("Saúde de " + teste.getNome() + ": " + teste.getSaude());
                    System.out.println("Energia de " + teste.getNome() + ": " + teste.getEnergia());
                    System.out.println("Fome de " + teste.getNome() + ": " + teste.getFome());
                    System.out.println("Felicidade de " + teste.getNome() + ": " + teste.getFelicidade());
                    System.out.println("Ciclo de vida de " + teste.getNome() + ": " + teste.getCicloDeVida());
        
                    break;
                case 1:
                    teste.comer();
                    System.out.println(teste.getNome() + " comeu e agora está com fome nível " + teste.getFome());
                    break;
                case 2:
                    teste.brincar();
                    System.out.println(teste.getNome() + " brincou e agora está com felicidade nível " + teste.getFelicidade());
                    break;
                case 3:
                    teste.dormir();
                    System.out.println(teste.getNome() + " dormiu e agora está com energia nível " + teste.getEnergia());
                    break;
                case 4:
                    teste.cuidar();
                    System.out.println(teste.getNome() + " foi cuidado e agora está com saúde nível " + teste.getEnergia());
                    break;
  
            }
        }
        
    }
    private static void mostraComandos(){
        System.out.println("Digite um comando: ");
        System.out.println("0 para verificar status");
        System.out.println("1 para comer");
        System.out.println("2 para brincar");
        System.out.println("3 para dormir");
        System.out.println("4 para cuidar");
    }
}
