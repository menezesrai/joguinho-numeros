import java.util.Random;
import java.util.Scanner;

public class App {

    private static double points; // Declare points as a global variable

    public static void main(String[] args) throws Exception {

        // cria o Scanner fora do loop pra não dar problema
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem vindo ao jogo de adivinhação!");
        System.out.println("Temos 3 dificuldades, fácil, médio e difícil.");
        System.out.println("Qual dificuldade você deseja jogar? (f, m, d)");
        String dif = scanner.nextLine();

        double maxAttempts;
        if (dif.equals("f")) {
            System.out.println("Você escolheu a dificuldade fácil!");
            maxAttempts = 15;
        } else if (dif.equals("m")) {
            System.out.println("Você escolheu a dificuldade média!");
            maxAttempts = 10;
        } else if (dif.equals("d")) {
            System.out.println("Você escolheu a dificuldade difícil!");
            maxAttempts = 5;
        } else {
            System.out.println("Você não escolheu nenhuma dificuldade, então vamos jogar na dificuldade média!");
            maxAttempts = 10;
        }

        boolean playAgain = true;

        while (playAgain) {
            // loop para gerar o número
            Random randomNumber = new Random();
            int numberComputer = randomNumber.nextInt(100) + 1; // essa parte gera um número entre 1 e 100.

            boolean acertou = false;
            int numberGuesses = 0;
            points = (1000 * maxAttempts * 0.4); // Initialize points at the start of each game

            // loop do número do usuário    
            while (!acertou) {
                System.out.println("Chuta um número entre 1 e 100 - Você tem " + (maxAttempts - numberGuesses) + " tentativas restantes");
                int userGuess = Integer.valueOf(scanner.nextLine());
                numberGuesses = numberGuesses + 1;
                if (numberGuesses == maxAttempts) {
                    System.out.println("Você perdeu! O número era " + numberComputer);
                    System.out.println("Deseja jogar novamente? (s/n)");
                    String answer = scanner.nextLine();
                    if (answer.equals("s")) {
                        acertou = false;
                        numberGuesses = 0; // resetar o número de tentativas
                        break;
                    } else {
                        System.out.println("Obrigado por jogar!");
                        playAgain = false;
                    }
                }

                if (userGuess < numberComputer) {
                    System.out.println("O número é maior");
                } else if (userGuess > numberComputer) {
                    System.out.println("O número é menor");
                } else {
                    acertou = true;
                    points = numberGuesses * 100 - 90;
                    System.out.println("Parabéns, você acertou! Você conseguiu em " + numberGuesses + " tentativas.");
                    System.out.println("Você fez " + points + " pontos!");

                    System.out.println("Deseja jogar novamente? (s/n)");
                    String answer = scanner.nextLine();
                    if (answer.equals("s")) {
                        acertou = false;
                        numberGuesses = 0; // resetar o número de tentativas
                        
                        break;
                    } else {
                        System.out.println("Obrigado por jogar!");
                        playAgain = false;
                    }
                }
            }
        }

        // fecha o Scanner
        scanner.close();
    }
}
