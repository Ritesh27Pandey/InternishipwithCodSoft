package ArrayList.Internship;
import java.util.Random;
import java.util.Scanner;

public class GuesstheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int score = 0;

        boolean playAgain = true;

        System.out.println("Welcome to the Guess the Number Game!");
        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("\nNew round! Guess a number between " + minRange + " and " + maxRange + ".");

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                System.out.print("Attempt " + attempt + ": ");
                int userGuess = scanner.nextInt();

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! Your guess is correct!");
                    score++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }

                if (attempt == maxAttempts) {
                    System.out.println("Out of attempts! The number was: " + targetNumber);
                }
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }

        System.out.println("\nGame Over! Your score is: " + score);
    }
}

    

