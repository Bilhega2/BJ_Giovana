package base;

import java.util.ArrayList;

import util.IO;

public class Player extends Jogador {

    public Player() {
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
    	IO.print("Sua mão:");
        for (Carta carta : maoJogador) {
            carta.exibir();
        }
    }
}
