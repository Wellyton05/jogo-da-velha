package jogo_da_velha;

import java.util.Scanner;

public class Model {
    private int[][] tabuleiro; // Representação do tabuleiro do jogo
    private char jogadorAtual;

    Scanner scanner = new Scanner(System.in);

    public Model() {
        tabuleiro = new int[3][3];
        jogadorAtual = 'X'; // Começar com o jogador X
        limparTabuleiro();
    }

    public void usuarioJoga(){
        System.out.println("Opções de jogada:");

        System.out.print("  ");
        for (int cont = 0; cont < tabuleiro.length; cont++) {   //colunas
            System.out.print(cont + "  ");
        }
        System.out.println();

        for (int i = 1; i < tabuleiro.length; i++) {    //linhas
            System.out.print(i + " ");
            for (int j = 1; j < tabuleiro.length; j++) {

                System.out.print("| ");
            }
            System.out.println("|");
        }
    }

    public void limparTabuleiro() {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                tabuleiro[linha][coluna] = 0;

            }
        }

    }


}
