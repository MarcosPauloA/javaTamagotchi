import javax.swing.*;
import java.awt.*;

// GRAPHIC USER INTERFACE
public class GUI {
    private static JLabel imagemTamagotchi;
    private static boolean trocouImagem;
    private static Tamagotchi tamagotchi;
    public static void main(String[] args) {
        
        GUI.tamagotchi = new Tamagotchi("Zé");

        // Criando o frame e adicionando os botões
        JFrame frame = new JFrame("Java Tamagotchi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        // Icone Botao Fome
        ImageIcon iconeFome = new ImageIcon("./assets/fome.png");
        JButton botaoFome = new JButton(iconeFome);
        botaoFome.setContentAreaFilled(false);
        botaoFome.addActionListener(e -> {
            // Handle button click here
            GUI.tamagotchi.comer();
            mudaImagem(frame, "saudavel");
        });


        // Icone Botao Energia
        ImageIcon iconeEnergia = new ImageIcon("./assets/energia.png");    
        JButton botaoEnergia = new JButton(iconeEnergia);
        // botaoEnergia.setBorder(BorderFactory.createEmptyBorder());
        botaoEnergia.setContentAreaFilled(false);
        botaoEnergia.addActionListener(e -> {
            // Handle button click here
            GUI.tamagotchi.dormir();
            mudaImagem(frame, "saudavel");
        });

        // Icone Botao Felicidade
        ImageIcon iconeFelicidade = new ImageIcon("./assets/dar-felicidade.png");    
        JButton botaoFelicidade = new JButton(iconeFelicidade);
        // botaoFelicidade.setBorder(BorderFactory.createEmptyBorder());
        botaoFelicidade.setContentAreaFilled(false);
        botaoFelicidade.addActionListener(e -> {
            // Handle button click here
            GUI.tamagotchi.brincar();
            mudaImagem(frame, "saudavel");
        });

        // Icone Botao Saude
        ImageIcon iconeSaude = new ImageIcon("./assets/cuidados-de-saude.png");    
        JButton botaoSaude = new JButton(iconeSaude);
        // botaoSaude.setBorder(BorderFactory.createEmptyBorder());
        botaoSaude.setContentAreaFilled(false);
        botaoSaude.addActionListener(e -> {
            // Handle button click here
            GUI.tamagotchi.cuidar();
            mudaImagem(frame, "saudavel");
        });


        GridBagConstraints restricoes = new GridBagConstraints();
        restricoes.fill = GridBagConstraints.HORIZONTAL;
        //restricoes.gridwidth = 2;
        restricoes.gridx = 0;
        restricoes.gridy = 0;
        restricoes.insets = new Insets(0, 50, 0, 50);
        frame.add(botaoEnergia, restricoes);
        restricoes.gridx = 1;
        frame.add(botaoFome, restricoes);
        restricoes.gridx = 2;
        frame.add(botaoFelicidade, restricoes);
        restricoes.gridx = 3;
        frame.add(botaoSaude, restricoes);

        // Barra de Fome
        JProgressBar barraDeFome = new JProgressBar(JProgressBar.HORIZONTAL);
        barraDeFome.setMinimum(0);
        barraDeFome.setMaximum(10);
        barraDeFome.setValue(10); // Defina um valor inicial (por exemplo, 100%)
        barraDeFome.setForeground(Color.GREEN);
        restricoes.gridx = 1;
        restricoes.gridy = 1;
        frame.add(barraDeFome, restricoes);

        // Barra de Energia
        JProgressBar barraDeEnergia = new JProgressBar(JProgressBar.HORIZONTAL);
        barraDeEnergia.setMinimum(0);
        barraDeEnergia.setMaximum(10);
        barraDeEnergia.setValue(10); // Defina um valor inicial (por exemplo, 100%)
        barraDeEnergia.setForeground(Color.GREEN);
        restricoes.gridx = 0;
        restricoes.gridy = 1;
        frame.add(barraDeEnergia, restricoes);

        // Barra de Felicidade
        JProgressBar barraDeFelicidade = new JProgressBar(JProgressBar.HORIZONTAL);
        barraDeFelicidade.setMinimum(0);
        barraDeFelicidade.setMaximum(10);
        barraDeFelicidade.setValue(10); // Defina um valor inicial (por exemplo, 100%)
        barraDeFelicidade.setForeground(Color.GREEN);
        restricoes.gridx = 2;
        restricoes.gridy = 1;
        frame.add(barraDeFelicidade, restricoes);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Define o estado da janela como maximizado

        // Barra de Saude
        JProgressBar barraDeSaude = new JProgressBar(JProgressBar.HORIZONTAL);
        barraDeSaude.setMinimum(0);
        barraDeSaude.setMaximum(10);
        barraDeSaude.setValue(10); // Defina um valor inicial (por exemplo, 100%)
        barraDeSaude.setForeground(Color.GREEN);
        restricoes.gridx = 3;
        restricoes.gridy = 1;
        frame.add(barraDeSaude, restricoes);
        frame.getContentPane().setBackground(Color.white);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Define o estado da janela como maximizado
            
        // Create a JLabel with the image
        GUI.imagemTamagotchi = new JLabel(new ImageIcon("./assets/bbDoente.jpg"));
        mudaImagem(frame, "saudavel");

        // Exiba o frame
        frame.setVisible(true);

        while (true){
            atualizaNivelBarra(barraDeEnergia, GUI.tamagotchi.getEnergia(), "cansado", frame);
            atualizaNivelBarra(barraDeFome, GUI.tamagotchi.getFome(), "com fome", frame);
            atualizaNivelBarra(barraDeSaude, GUI.tamagotchi.getSaude(), "doente", frame);
            atualizaNivelBarra(barraDeFelicidade, GUI.tamagotchi.getFelicidade(), "triste", frame);
            
        }
    }
/* 
    private static void tornarJanelaTelaCheia(JFrame janela) {
        GraphicsDevice dispositivo = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        janela.setUndecorated(true); // Remove a barra de título e bordas
        janela.setExtendedState(JFrame.MAXIMIZED_BOTH); // Define o estado da janela como maximizado
        dispositivo.setFullScreenWindow(janela); // Coloca a janela em modo de tela cheia
        janela.setVisible(true); // Torna a janela visível
    }
*/
    private static void atualizaNivelBarra(JProgressBar barra, float valorAtual, String estado, JFrame frame){
        if (valorAtual >= 6){
            barra.setValue(Math.round(valorAtual)); 
            barra.setForeground(Color.GREEN);
        } 
        else if (valorAtual > 3){
            barra.setValue(Math.round(valorAtual)); 
            barra.setForeground(Color.YELLOW); 
        } 
        else {
            barra.setValue(Math.round(valorAtual)); 
            barra.setForeground(Color.RED);

            mudaImagem(frame, estado);
        }
    }

    private static void mudaImagem(JFrame frame, String estado){

        GridBagConstraints restricoes = new GridBagConstraints();
        restricoes.gridwidth = 3;
        restricoes.gridheight = 6;
        restricoes.gridx = 1;
        restricoes.gridy = 1;
        GUI.imagemTamagotchi.setBorder(BorderFactory.createEmptyBorder());
        if ((estado == "com fome") && (!GUI.trocouImagem)){
            frame.remove(GUI.imagemTamagotchi);
            GUI.imagemTamagotchi.setIcon(new ImageIcon("./assets/bbFome.jpg"));
            GUI.trocouImagem = true;
            frame.add(GUI.imagemTamagotchi, restricoes);
            frame.revalidate(); 
            frame.repaint();
        }
        if ((estado == "doente") && (!GUI.trocouImagem)){
            frame.remove(GUI.imagemTamagotchi);
            GUI.imagemTamagotchi.setIcon(new ImageIcon("./assets/bbDoente.jpg"));
            GUI.trocouImagem = true;
            frame.add(GUI.imagemTamagotchi, restricoes);
            frame.revalidate(); 
            frame.repaint();

        }
        if ((estado == "triste") && (!GUI.trocouImagem)){
            frame.remove(GUI.imagemTamagotchi);
            GUI.imagemTamagotchi.setIcon(new ImageIcon("./assets/bbTriste.jpeg"));
            GUI.trocouImagem = true;
            frame.add(GUI.imagemTamagotchi, restricoes);
            frame.revalidate(); 
            frame.repaint();
        }
        if ((estado == "cansado") && (!GUI.trocouImagem)){
            frame.remove(GUI.imagemTamagotchi);
            GUI.imagemTamagotchi.setIcon(new ImageIcon("./assets/bbCansado.jpg"));
            GUI.trocouImagem = true;
            frame.add(GUI.imagemTamagotchi, restricoes);
            frame.revalidate(); 
            frame.repaint();
        }
        if (estado == "saudavel" && nenhumEstadoVermelho()){
            GUI.trocouImagem = false;
            GUI.imagemTamagotchi.setIcon(new ImageIcon("./assets/bbSaudavel.jpg"));
            frame.add(GUI.imagemTamagotchi, restricoes);
            frame.revalidate(); 
            frame.repaint();
        } else if (estado == "saudavel" && !nenhumEstadoVermelho()) {GUI.trocouImagem = false;}
    }
    static boolean nenhumEstadoVermelho(){
        if(Math.round(GUI.tamagotchi.getEnergia()) > 3 &&
            Math.round(GUI.tamagotchi.getFelicidade()) > 3 &&
            Math.round(GUI.tamagotchi.getFome()) > 3 &&
            Math.round(GUI.tamagotchi.getEnergia()) > 3){
                return true;
            }
        else{
            return false;
        }
    }
}
