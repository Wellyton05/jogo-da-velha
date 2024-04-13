/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo_da_velha;

/**
 *
 * @author 7468474
 */
public class View {

    private int[][] tabuleiro = new int[3][3]; // variavel do nosso tabuleiro

    public void Tabuleiro() {
        limparTabuleiro();
    }

    public void limparTabuleiro() {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                tabuleiro[linha][linha] = 0;

            }
        }

    }

    public void mostrarTabuleiro() {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                
                switch (tabuleiro[linha][coluna]) {
                    case 0:
                        System.out.print("-");
                        break;
                    case 1:
                        System.out.print("O");
                        break;
                    case 2:
                        System.out.print(" ");
                        break;
                    case 3:
                        System.out.print("X");
                        break;
   
               }
            }
             System.out.println("");
        }
    }
}
