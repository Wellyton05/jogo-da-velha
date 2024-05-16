package jogo_da_velha;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;
    private Scanner scanner;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        scanner = new Scanner(System.in);
    }

    public void iniciarJogo() {
        view.exibirMensagem("Bem-vindo ao Jogo da Velha!");
        view.exibirMensagem("Escolha 'X' ou 'O': ");
        char jogadorEscolhido = escolherJogador();
        char jogadorComputador = (jogadorEscolhido == 'X') ? 'O' : 'X';

        while (true) {
            if (jogadorEscolhido == model.getJogadorAtual()) {
                view.mostrarTabuleiro(model.getTabuleiro());
                view.exibirMensagem("Sua vez, jogador " + jogadorEscolhido + ". Informe sua jogada (linha coluna):");

                int linha = obterEntrada("Linha:");
                int coluna = obterEntrada("Coluna:");

                if (model.fazerMovimento(linha, coluna)) {
                    if (model.verificarVitoria()) {
                        view.mostrarTabuleiro(model.getTabuleiro());
                        view.exibirMensagem("Parabéns! Jogador " + jogadorEscolhido + " venceu!");
                        break;
                    } else if (model.tabuleiroCheio()) {
                        view.mostrarTabuleiro(model.getTabuleiro());
                        view.exibirMensagem("O jogo terminou em empate!");
                        break;
                    }
                } else {
                    view.exibirMensagem("Movimento inválido. Tente novamente.");
                }
            } else {
                // Jogada do computador (IA simples)
                int[] movimento = calcularMovimento();
                model.fazerMovimento(movimento[0], movimento[1]);
                if (model.verificarVitoria()) {
                    view.mostrarTabuleiro(model.getTabuleiro());
                    view.exibirMensagem("Você perdeu! O computador venceu.");
                    break;
                }
            }
        }
        reiniciarJogo();
    }

    private char escolherJogador() {
        while (true) {
            String escolha = scanner.nextLine().toUpperCase();
            if (escolha.equals("X") || escolha.equals("O")) {
                return escolha.charAt(0);
            } else {
                view.exibirMensagem("Escolha inválida. Por favor, escolha 'X' ou 'O'.");
            }
        }
    }

    private int obterEntrada(String prompt) {
        int valor;
        while (true) {
            try {
                view.exibirMensagem(prompt);
                valor = Integer.parseInt(scanner.nextLine());
                if (valor >= 0 && valor <= 2) {
                    break;
                } else {
                    view.exibirMensagem("Por favor, insira um valor entre 0 e 2.");
                }
            } catch (NumberFormatException e) {
                view.exibirMensagem("Entrada inválida. Por favor, insira um número.");
            }
        }
        return valor;
    }

    private int[] calcularMovimento() {
        int[][] tabuleiro = model.getTabuleiro();
        // Lógica da IA
        for (int i = 0; i < 3; i++) {
            int linhaProduto = tabuleiro[i][0] * tabuleiro[i][1] * tabuleiro[i][2];
            if (linhaProduto == 1) {
                for (int j = 0; j < 3; j++) {
                    if (tabuleiro[i][j] == 0) {
                        return new int[]{i, j};
                    }
                }
            }
        }

        for (int j = 0; j < 3; j++) {
            int colunaProduto = tabuleiro[0][j] * tabuleiro[1][j] * tabuleiro[2][j];
            if (colunaProduto == 1) {
                for (int i = 0; i < 3; i++) {
                    if (tabuleiro[i][j] == 0) {
                        return new int[]{i, j};
                    }
                }
            }
        }

        // Se não encontrar uma jogada que impeça a vitória do jogador, joga em qualquer posição vazia
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }

        // Nunca deve chegar aqui, mas caso contrário, retorna uma posição inválida
        return new int[]{-1, -1};
    }

    private void reiniciarJogo() {
        view.exibirMensagem("Deseja jogar novamente? (S/N)");
        String resposta = scanner.nextLine().toUpperCase();
        if (resposta.equals("S")) {
            model.reiniciarJogo();
            iniciarJogo();
        } else {
            view.exibirMensagem("Obrigado por jogar!");
        }
    }

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controlador = new Controller(model, view);
        controlador.iniciarJogo();
    }
}
