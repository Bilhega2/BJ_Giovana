package base;

import java.util.ArrayList;
import java.util.Collections;

public class BaralhoBJ extends Baralho {

    public BaralhoBJ() {
        this.nipes = new String[]{"Copas", "Ouros", "Paus", "Espadas"};
        this.valores = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        this.cartas = new ArrayList<>();
        gerarBaralho();
        embaralhar();
 }

    @Override
    public void gerarBaralho() {
        cartas.clear();
        for (String nipe : nipes) {
          for (String valor : valores) {
              int pontuacao;
              switch (valor) {
                  case "J":
                  case "Q":
                  case "K":
                    pontuacao = 10;
                      break;
                  case "A":
                     pontuacao = 11; 
                      break;
                default:
                     pontuacao = Integer.parseInt(valor);
                      break;
                }
                cartas.add(new CartaBJ(nipe, valor, pontuacao));
            }
        }
    }

    @Override
    public void embaralhar() {
        Collections.shuffle(cartas);
    }

    @Override
    public Carta darCarta() {
        if (cartas.isEmpty()) {
            verificarEPreencherBaralho();
        }
        return cartas.remove(0);
    }

    @Override
    public ArrayList<Carta> darCartas() {
        ArrayList<Carta> mao = new ArrayList<>();
        mao.add(darCarta());
        mao.add(darCarta());
        return mao;
    }

    @Override
    protected void exibirBaralho() {
        for (Carta carta : cartas) {
            carta.exibir();
        }
    }

    @Override
    protected void verificarEPreencherBaralho() {
        if (cartas.isEmpty()) {
            gerarBaralho();
            embaralhar();
        }
    }
}
