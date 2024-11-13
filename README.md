
# Ping Pong Game - Java
Este é um simples jogo de Pong implementado em Java, utilizando a biblioteca java.awt para a interface gráfica. O jogo permite que o jogador controle uma raquete e jogue contra um inimigo controlado pelo computador. O objetivo é marcar pontos ao fazer a bola passar pela raquete do oponente. O jogo termina quando um dos jogadores atinge 10 pontos.

# Funcionalidades
Jogador e Inimigo: O jogador controla a raquete à esquerda, enquanto o inimigo controla a raquete à direita da tela. A raquete do inimigo se move automaticamente para tentar interceptar a bola.
Bola: A bola se move pela tela e rebate nas raquetes. Quando a bola ultrapassa uma das extremidades do campo, um ponto é atribuído ao oponente.
Pontuação: A pontuação de cada jogador é exibida na tela. O jogo termina quando um jogador alcança 10 pontos.
Estrutura do Código
O código está dividido em várias classes:

1. Classe Pong (Principal)
Responsabilidade: Controla o fluxo principal do jogo, incluindo a inicialização do jogo, a criação da janela e a execução do loop principal do jogo.
Principais Métodos:
main: Inicia o jogo e configura a interface gráfica.
run: Responsável pelo loop de atualização e renderização do jogo.
desenhar: Desenha o cenário, as raquetes e a bola na tela.
atualizar: Atualiza o estado dos objetos no jogo (posição das raquetes e bola).
keyPressed e keyReleased: Controlam os movimentos da raquete do jogador com as teclas UP e DOWN.
2. Classe Jogador
Responsabilidade: Representa a raquete do jogador e controla seus movimentos.
Principais Métodos:
desenhar: Desenha a raquete do jogador.
atualizar: Atualiza a posição da raquete com base nas teclas pressionadas.
3. Classe Inimigo
Responsabilidade: Representa a raquete do inimigo, que se move automaticamente para tentar interceptar a bola.
Principais Métodos:
desenhar: Desenha a raquete do inimigo.
atualizar: Atualiza a posição da raquete do inimigo com base na posição da bola.
4. Classe Bola
Responsabilidade: Controla o movimento da bola e a colisão com as raquetes.
Principais Métodos:
desenhar: Desenha a bola na tela.
atualizar: Atualiza a posição da bola e verifica colisões com as raquetes. Quando a bola ultrapassa uma raquete, o placar é atualizado.
Como Rodar o Jogo
Pré-requisitos: Certifique-se de ter o Java instalado em seu sistema (recomenda-se a versão 8 ou superior).

Compilação:

Compile os arquivos Java usando o comando:
bash
Copiar código
javac Pong.java Jogador.java Inimigo.java Bola.java
Execução:

Após compilar, execute o programa com o seguinte comando:
bash
Copiar código
java Pong
Controles:

Use as teclas UP e DOWN para mover a raquete do jogador para cima e para baixo.
A raquete do inimigo se moverá automaticamente em direção à bola.
Explicação do Código
Tela e Interface Gráfica: O jogo é exibido em uma janela usando a classe JFrame do Swing e a classe Canvas do AWT para renderizar os elementos do jogo.
Movimentação da Bola: A bola se move a uma velocidade constante e muda de direção ao colidir com as raquetes. Quando a bola ultrapassa um dos limites laterais da tela, um ponto é atribuído ao adversário.
Inteligência Artificial do Inimigo: O movimento do inimigo é simples, ele tenta sempre se posicionar na direção vertical da bola, criando uma IA básica que simula o comportamento de um adversário.
