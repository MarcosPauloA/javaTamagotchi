import javax.swing.*;
import java.awt.*;

// GRAPHIC USER INTERFACE
public class GUI {

    public static void main(String[] args) {
        Tamagotchi tamagotchi = new Tamagotchi("Zé");

        // Icone Botao Fome
        ImageIcon iconeFome = new ImageIcon("./fome2.png");
        JButton botaoFome = new JButton(iconeFome);
        botaoFome.setBorder(BorderFactory.createEmptyBorder());
        botaoFome.setContentAreaFilled(false);
        botaoFome.addActionListener(e -> {
            // Handle button click here
            tamagotchi.comer();
        });

        // Icone Botao Energia
        ImageIcon iconeEnergia = new ImageIcon("./energia2.png");    
        JButton botaoEnergia = new JButton(iconeEnergia);
        botaoEnergia.setBorder(BorderFactory.createEmptyBorder());
        botaoEnergia.setContentAreaFilled(false);
        botaoEnergia.addActionListener(e -> {
            // Handle button click here
            tamagotchi.dormir();
        });

        // Icone Botao Felicidade
        ImageIcon iconeFelicidade = new ImageIcon("./dar-felicidade.png");    
        JButton botaoFelicidade = new JButton(iconeFelicidade);
        botaoFelicidade.setBorder(BorderFactory.createEmptyBorder());
        botaoFelicidade.setContentAreaFilled(false);
        botaoFelicidade.addActionListener(e -> {
            // Handle button click here
            tamagotchi.brincar();
        });

        // Icone Botao Saude
        ImageIcon iconeSaude = new ImageIcon("./cuidados-de-saude.png");    
        JButton botaoSaude = new JButton(iconeSaude);
        botaoSaude.setBorder(BorderFactory.createEmptyBorder());
        botaoSaude.setContentAreaFilled(false);
        botaoSaude.addActionListener(e -> {
            // Handle button click here
            tamagotchi.cuidar();
        });

        // Criando o frame e adicionando os botões
        JFrame frame = new JFrame("Java Tamagotchi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
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

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Define o estado da janela como maximizado
        // Exiba o frame
        frame.setVisible(true);

        while (true){
            atualizaNivelBarra(barraDeEnergia, tamagotchi.getEnergia());
            atualizaNivelBarra(barraDeFome, tamagotchi.getFome());
            atualizaNivelBarra(barraDeSaude, tamagotchi.getSaude());
            atualizaNivelBarra(barraDeFelicidade, tamagotchi.getFelicidade());
            
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
    private static void atualizaNivelBarra(JProgressBar barra, int valorAtual){
        if (valorAtual >= 6){
            barra.setValue(valorAtual); 
            barra.setForeground(Color.GREEN);
        } 
        else if (valorAtual > 3){
            barra.setValue(valorAtual); 
            barra.setForeground(Color.YELLOW); 
        } 
        else {
            barra.setValue(valorAtual); 
            barra.setForeground(Color.RED);
        }
    }

}
