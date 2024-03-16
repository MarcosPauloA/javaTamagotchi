import javax.swing.*;
import java.awt.*;

public class GUI {

    public static void main(String[] args) {
        ImageIcon icon = new ImageIcon("./fome.png");

        JButton button = new JButton(icon);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setContentAreaFilled(false);

        button.addActionListener(e -> {
            // Handle button click here
            System.out.println("Button clicked!");
        });

        JFrame frame = new JFrame("Image Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.getContentPane().add(button, BorderLayout.PAGE_START);
        //frame.pack();
        //frame.setVisible(true);
        
        // Crie um JFrame
        //JFrame frame2 = new JFrame("Exemplo de Barra de Progresso Horizontal");
        //frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame2.setSize(300, 100);

        // Crie uma JProgressBar
        JProgressBar progressBar = new JProgressBar(JProgressBar.HORIZONTAL);
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        progressBar.setValue(50); // Defina um valor inicial (por exemplo, 50%)

        // Adicione a barra de progresso ao frame
        frame.add(progressBar, BorderLayout.CENTER);

        // Exiba o frame
        //frame2.setVisible(true);
        tornarJanelaTelaCheia(frame);
    }

    private static void tornarJanelaTelaCheia(JFrame janela) {
        GraphicsDevice dispositivo = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        janela.setUndecorated(true); // Remove a barra de título e bordas
        janela.setExtendedState(JFrame.MAXIMIZED_BOTH); // Define o estado da janela como maximizado
        dispositivo.setFullScreenWindow(janela); // Coloca a janela em modo de tela cheia
        janela.setVisible(true); // Torna a janela visível
    }

}
