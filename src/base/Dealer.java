package base;

import java.util.ArrayList;

public class Dealer extends Jogador {

    public Dealer() {
        this.maoJogador = new ArrayList<>();
        this.numCartas = 0;
    }

    @Override
    public void comprarCarta(Carta carta) {
        maoJogador.add(carta);
        numCartas++;
    }

    @Override
    public void comprarCartas(ArrayList<Carta> cartas) {
        maoJogador.addAll(cartas);
        numCartas += cartas.size();
    }

    @Override
    protected void exibirMao() {
        System.out.println("Mão do Dealer:");
        for (int i = 0; i < maoJogador.size(); i++) {
            if (i == 0) {
                System.out.println("[Carta Oculta]");
            } else {
                maoJogador.get(i).exibir();
           }
       }
    }

    public void exibirMaoCompleta() {
        System.out.println("Mão do Dealer:");
        for (Carta carta : maoJogador) {
            carta.exibir();
        }
    }
}
