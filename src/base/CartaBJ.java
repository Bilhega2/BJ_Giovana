package base;

import util.IO;

public class CartaBJ extends Carta {
    public CartaBJ(String nipe, String valor, int pontuacao) {
        this.nipe = nipe;
        this.valor = valor;
        this.pontuacao = pontuacao;
    }

    @Override
    public String getNipe() {
        return nipe;
    }

    @Override
    public String getValor() {
        return valor;
    }

    @Override
    public int getPontuacao() {
        return pontuacao;
    }

    @Override
    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public void exibir() {
    	IO.print(valor + " de " + nipe + " (Pontuação: " + pontuacao + ")");
    }
}