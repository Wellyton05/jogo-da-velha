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

//    public void Tabuleiro() {
//        limparTabuleiro();
//    }



    public void mostrarTabuleiro(int[][] matriz ) {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                if(tabuleiro[linha][coluna]== -1){
                    System.out.print(" X ");
                }
                if(tabuleiro[linha][coluna]==1){
                    System.out.print(" O ");
                }
                if(tabuleiro[linha][coluna]==0){
                    System.out.print("   ");
                }

                if(coluna==0 || coluna==1)
                    System.out.print("|");
            }
             System.out.println();
        }
    }
}
