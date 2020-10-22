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
        int tentativaJogador1;
        int tentativaJogador2;
        Scanner leia = new Scanner(System.in);

        do {
            numeroAleatorio = geradorNumeroAleatorio(LIMITE);

            System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬_JOGO_DO_ACERTO_¬¬¬¬¬¬¬¬¬¬¬¬");
            System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
            System.out.print("Jogador 1 - Digite um número de 1 á " + LIMITE + ": ");
            tentativaJogador1 = leia.nextInt();
            System.out.print("Jogador 2 - Digite um número de 1 á " + LIMITE + ": ");
            tentativaJogador2 = leia.nextInt();

            System.out.println();
            this.verificarVitoria("Jogador 1 -> ", tentativaJogador1, numeroAleatorio);
            this.verificarVitoria("Jogador 2 -> ", tentativaJogador2, numeroAleatorio);

            System.out.println();
        } while (this.executarNovamente());

        System.out.println("Saindo...");
    }

    public void verificarVitoria(String jogador, int tentativaJogador, int numeroAleatorio) {
        if (tentativaJogador == numeroAleatorio) {
            System.out.println(jogador + " Você acertou. Parabéns!");
        } else {
            System.out.println(VERMELHO + jogador + " Você errou!" + RESETAR);
        }
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
