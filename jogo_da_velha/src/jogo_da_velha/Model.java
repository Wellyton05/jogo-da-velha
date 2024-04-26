package jogo_da_velha;

public class Model {
    private int[][] tabuleiro; // Representação do tabuleiro do jogo
    private char jogadorAtual;

    public Model() {
        tabuleiro = new int[3][3];
        jogadorAtual = 'X'; // Começar com o jogador X
        limparTabuleiro();
    }
    public void limparTabuleiro() {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                tabuleiro[linha][coluna] = 0;

            }
        }

    }

    public int getPosicao(int linha, int coluna) {
        return tabuleiro[linha][coluna];
    }

    public void setPosicao(int linha, int coluna, int jogador){
        if(jogador ==  1){
             tabuleiro[linha][coluna] = -1;
        }else{
            tabuleiro[linha][coluna] = 1;

        }
    }

    public void validarPosicao(int linha, int coluna){
        if(getPosicao(linha, coluna)){

        }

    }

}
