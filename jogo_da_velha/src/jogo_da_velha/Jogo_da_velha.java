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
public class Jogo_da_velha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[][] matriz = new int[3][3];

        View tabuleiro = new View();
        tabuleiro.mostrarTabuleiro(matriz);

        Model teste = new Model();
        teste.usuarioJoga();
    }

}
