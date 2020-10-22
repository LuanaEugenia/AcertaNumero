import java.util.Random;
import java.util.Scanner;

public class AcertaNumero {
    private final String VERMELHO = "\u001B[31m";
    private final String RESETAR = "\u001B[0m";

    public static void main(String[] args) {
        new AcertaNumero().inicializador();
    }

    public void inicializador() {
        final int LIMITE = 6;
        int numeroAleatorio;
        Scanner leia = new Scanner(System.in);

        do {
            boolean alguemVenceu;
            int tentativaJogador1;
            int tentativaJogador2;
            int pontosJogador1 = 0;
            int pontosJogador2 = 0;

            do {
                System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬_JOGO_DO_ACERTO_¬¬¬¬¬¬¬¬¬¬¬¬");
                System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
                System.out.print("Jogador 1 - Digite um número de 1 á " + LIMITE + ": ");
                tentativaJogador1 = leia.nextInt();
                System.out.print("Jogador 2 - Digite um número de 1 á " + LIMITE + ": ");
                tentativaJogador2 = leia.nextInt();

                numeroAleatorio = geradorNumeroAleatorio(LIMITE);
                System.out.println();

                if (this.verificarVitoriaRodada("Jogador 1 -> ", tentativaJogador1, numeroAleatorio)) {
                    pontosJogador1++;
                }

                if (this.verificarVitoriaRodada("Jogador 2 -> ", tentativaJogador2, numeroAleatorio)) {
                    pontosJogador2++;
                }

                alguemVenceu = verificarVitoria(pontosJogador1, pontosJogador2);

                System.out.println();
            } while (!alguemVenceu);
        } while (this.executarNovamente());

        System.out.println("Saindo...");
    }

    public boolean verificarVitoria(int pontosJogador1, int pontosJogador2) {
        boolean alguemVenceu = false;

        if (pontosJogador1 == 3 && pontosJogador2 == 3) {
            System.out.println("\n¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
            System.out.println("Empate");
            System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
            alguemVenceu = true;
        } else if (pontosJogador1 == 3) {
            System.out.println("\n¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
            System.out.println("Jogador 1 -> Você gahou");
            System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
            alguemVenceu = true;
        } else if (pontosJogador2 == 3) {
            System.out.println("\n¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
            System.out.println("Jogador 2 -> Você gahou");
            System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
            alguemVenceu = true;
        }

        return alguemVenceu;
    }

    public boolean verificarVitoriaRodada(String jogador, int tentativaJogador, int numeroAleatorio) {
        if (tentativaJogador == numeroAleatorio) {
            System.out.println(jogador + " Você acertou. Parabéns!");
            return true;
        }

        System.out.println(VERMELHO + jogador + " Você errou!" + RESETAR);
        return false;
    }

    public boolean executarNovamente() {
        final int SIM = 1;
        final int NAO = 2;
        int executarNovamente;
        Scanner leia = new Scanner(System.in);

        do {
            System.out.print("Gostaria de jogar novamente? Digite " + SIM + " / SIM - " + NAO + " / NÃO: ");
            executarNovamente = leia.nextInt();

            if (executarNovamente != SIM && executarNovamente != NAO) {
                System.out.println("\n¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
                System.out.println(VERMELHO + "Opção inválida! Tente de novo." + RESETAR);
                System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
            }

            System.out.println();
        } while (executarNovamente != SIM && executarNovamente != NAO);

        return executarNovamente == SIM;
    }

    public int geradorNumeroAleatorio(int limite) {
        return new Random().nextInt(limite) + 1;
    }
}
