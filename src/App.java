import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        // cria o Scanner fora do loop pra não dar problema
        Scanner scanner = new Scanner(System.in);

        boolean playAgain = true;

        while (playAgain) {
            // loop para gerar o número
            Random randomNumber = new Random();
            int numberComputer = randomNumber.nextInt(100) + 1; // essa parte gera um número entre 1 e 100.

            boolean acertou = false;
            int numberGuesses = 0;
            int points = 1000;

            // loop do número do usuário    
            while (!acertou) {
                System.out.println("Chuta um número entre 1 e 100 - Você tem 10 tentativas");
                int userGuess = Integer.valueOf(scanner.nextLine());
                numberGuesses = numberGuesses + 1;
                 if (numberGuesses == 10) {
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
                        points = 0; // resetar os pontos
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
