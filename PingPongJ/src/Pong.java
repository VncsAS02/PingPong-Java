import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pong extends Canvas implements Runnable, KeyListener {
    public static int largura = 450;
    public static int altura = 400;
    public static Jogador jogador;
    public static Inimigo inimigo;
    public static Bola bola;

    // Variáveis de pontuação
    public static int pontuacaoJogador = 0;
    public static int pontuacaoInimigo = 0;

    public Pong() {
        this.setPreferredSize(new Dimension(largura, altura));
        this.addKeyListener(this);
    }

    public static void main(String[] args) throws Exception {
        Pong pong = new Pong();
        jogador = new Jogador(15, 150);
        inimigo = new Inimigo(425, 150);
        bola = new Bola(255, 200);
        JFrame jframe = new JFrame();
        jframe.setVisible(true);
        jframe.add(pong);
        pong.requestFocus();
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new Thread(pong).start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                desenhar();
                atualizar();
                if (pontuacaoJogador >= 10 || pontuacaoInimigo >= 10) {
                    System.out.println("Fim de Jogo!");
                    if (pontuacaoJogador >= 10) {
                        System.out.println("Jogador Venceu!");
                    } else {
                        System.out.println("Inimigo Venceu!");
                    }
                    System.exit(0); // Encerra o jogo
                }
                Thread.sleep(1000 / 30);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void desenhar() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics grafico = bs.getDrawGraphics();
        grafico.setColor(new Color(0, 0, 0));
        grafico.fillRect(0, 0, largura, altura);
        jogador.desenhar(grafico);
        inimigo.desenhar(grafico);
        bola.desenhar(grafico);

        grafico.setColor(new Color(255, 255, 255));
        grafico.drawString("Jogador: " + pontuacaoJogador, 20, 20);
        grafico.drawString("Inimigo: " + pontuacaoInimigo, largura - 100, 20);

        bs.show();
    }

    private void atualizar() {
        jogador.atualizar();
        inimigo.atualizar();
        bola.atualizar();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            jogador.up = true;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            jogador.down = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            jogador.up = false;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            jogador.down = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
