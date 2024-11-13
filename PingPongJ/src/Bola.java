import java.util.Random;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

public class Bola {
    public int x;
    public int y;
    public int raio;
    public double direcaox;
    public double direcaoy;
    public double velociade = 5.5;

    public Bola(int x, int y) {
        this.x = x;
        this.y = y;
        this.raio = 10;

        int angulo = new Random().nextInt(80);
        direcaox = Math.cos(Math.toRadians(angulo));
        direcaoy = Math.sin(Math.toRadians(angulo));
    }

    public void desenhar(Graphics grafico) {
        grafico.setColor(new Color(255, 255, 255));
        grafico.fillOval(x, y, raio * 2, raio * 2);
    }

    public void atualizar() {
        if (y + (direcaoy * velociade) + raio * 2 >= Pong.altura || y + (direcaoy * velociade) < 0) {
            direcaoy *= -1;
        }

        Rectangle bolaRect = new Rectangle(x + (int) (direcaox * velociade), y + (int) (direcaoy * velociade), raio * 2, raio * 2);
        Rectangle jogador = new Rectangle(Pong.jogador.x, Pong.jogador.y, Pong.jogador.larguraJogador, Pong.jogador.alturaJogador);
        Rectangle inimigo = new Rectangle(Pong.inimigo.x, Pong.inimigo.y, Pong.inimigo.larguraInimigo, Pong.inimigo.alturaInimigo);

        if (bolaRect.intersects(jogador)) {
            int angulo = new Random().nextInt(80);
            direcaox = Math.cos(Math.toRadians(angulo));
            direcaoy = Math.sin(Math.toRadians(angulo));
            if (direcaox < 0) {
                direcaox *= -1;
            }
        } else if (bolaRect.intersects(inimigo)) {
            int angulo = new Random().nextInt(80);
            direcaox = Math.cos(Math.toRadians(angulo));
            direcaoy = Math.sin(Math.toRadians(angulo));
            if (direcaox > 0) {
                direcaox *= -1;
            }
        }

        x += direcaox * velociade;
        y += direcaoy * velociade;

        // Verifica se a bola passou das extremidades do tabuleiro
        if (x < 0) {
            Pong.pontuacaoInimigo++;
            resetar();
        } else if (x > Pong.largura) {
            Pong.pontuacaoJogador++;
            resetar();
        }
    }

    // Reinicia a bola na posição central do tabuleiro
    private void resetar() {
        this.x = Pong.largura / 2;
        this.y = Pong.altura / 2;
        int angulo = new Random().nextInt(80);
        direcaox = Math.cos(Math.toRadians(angulo));
        direcaoy = Math.sin(Math.toRadians(angulo));
    }
}
