package base;

import util.IO;

public class BlackJackGame {
    private BaralhoBJ baralho;
    private Dealer dealer;
    private Player player;

    public BlackJackGame() {
        this.baralho = new BaralhoBJ();
        this.dealer = new Dealer();
        this.player = new Player();
    }

    public void iniciarJogo() {
        IO.print("Bem-vindo ao BlackJack!");
        
        player.comprarCartas(baralho.darCartas());
        dealer.comprarCartas(baralho.darCartas());
        player.exibirMao();
        dealer.exibirMao();
        
        boolean jogadorContinua = true;
        while (jogadorContinua) {
            String acao = IO.readString("Você quer comprar ou manter?");
            if (acao.equalsIgnoreCase("comprar")) {
                	player.comprarCarta(baralho.darCarta());
                	player.exibirMao();
            if (calcularPontuacao(player) > 21) {
                	IO.print("Você perdeu!");
                    return;
                }
            
            } else if (acao.equalsIgnoreCase("manter")) {
                	jogadorContinua = false;
            } else {
            		IO.print("Entrada inválida!");
            }
        }
        
        while (calcularPontuacao(dealer) < 17) {
            		dealer.comprarCarta(baralho.darCarta());
        }
        			dealer.exibirMaoCompleta();

        int pontuacaoJogador = calcularPontuacao(player);
        int pontuacaoDealer = calcularPontuacao(dealer);
        
        IO.print("Sua pontuação: " + pontuacaoJogador);
        IO.print("Pontuação do Dealer: " + pontuacaoDealer);
        
        if (pontuacaoDealer > 21 || pontuacaoJogador > pontuacaoDealer) {
        	IO.print("Você venceu!");
        } else if (pontuacaoJogador == pontuacaoDealer) {
        	IO.print("Empate!");
        } else {
        	IO.print("Dealer venceu!");
        }
}
    private int calcularPontuacao(Jogador jogador) {
        	int total = 0;
        	int numAs = 0;
        	for (Carta carta : jogador.maoJogador) {
        		total += carta.getPontuacao();
            if (carta.getValor().equals("A")) {
                numAs++;
          }
        }
        while (total > 21 && numAs > 0) {
            total -= 10;
            numAs--;
        }
        return total;
    }


    public static void main(String[] args) {
        BlackJackGame jogo = new BlackJackGame();
        jogo.iniciarJogo();
    }
}
