import java.util.Random;
import java.util.Scanner;

public class AcertaNumero {
    private final String VERMELHO = "\u001B[31m";
    private final String RESETAR = "\u001B[0m";

    public static void main(String[] args) {
        new AcertaNumero().inicializador();
    }

    public void inicializador() {
        Scanner leia = new Scanner(System.in);
        int tentativaJogador;
        int numeroAleatorio;

        do {
            numeroAleatorio = geradorNumeroAleatorio(3);

            System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬_JOGO_DO_ACERTO_¬¬¬¬¬¬¬¬¬¬¬¬");
            System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
            System.out.print("Digite um número de 1 á 3: ");
            tentativaJogador = leia.nextInt();

            System.out.println();

            this.verificarVitoria(tentativaJogador, numeroAleatorio);

            System.out.println();
        } while (this.executarNovamente());

        System.out.println("Saindo...");
    }

    public void verificarVitoria(int tentativaJogador, int numeroAleatorio) {
        if (tentativaJogador == numeroAleatorio) {
            System.out.println("Você acertou. Parabéns!");
        } else {
            System.out.println(VERMELHO + "Você errou!" + RESETAR);
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
