import java.util.Random;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int round = 1;
        int bestScore = 8;
        int roundWins = 0;
        boolean continueGame = true;

        while (continueGame) {
            System.out.println("Round " + round + "   __________  " +  "Round wins: " + roundWins + "   __________  " +  "Top Score: " + bestScore );
            System.out.println("You have 8 attempts");
            System.out.println("Guess a number between 1 and 100: ");

            // Read the user input as an integer
            int guess = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            // Generate a random number between 1 and 100
            int randomNumber = random.nextInt(100) + 1;

            if (guess==randomNumber){
                System.out.println("YOU Guessed the number from one attemps ! WOW ");
                System.out.println("Round " + round + "   __________  " +  "Round wins: " + roundWins + "   __________  " +  "Top Score: " + bestScore );
            }

            int attempts = 1;

            while (attempts < 8) {

                if (guess == randomNumber) {
                    System.out.println("Correct! You guessed the number.");
                    System.out.println("Your score is: " + attempts);
                    roundWins++;
                    if (attempts < bestScore) {
                        bestScore = attempts;
                    }
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too low. Guess a higher number.");
                } else {
                    System.out.println("Too high. Guess a lower number.");
                }

                // Read the next guess from the user
                guess = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                attempts++;
            }

            if (attempts == 8 && guess != randomNumber) {
                System.out.println("Too many attempts! The number was " + randomNumber);
            }

            System.out.println("Do you want to continue? (yes/no)");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("yes")) {
                continueGame = true;
                round++;
            } else {
                System.out.println("Total Rounds " + round + "   __________  " +  "Round wins: " + roundWins + "   __________  " +  "Best Score: " + bestScore );
                continueGame = false;
            }
        }

        scanner.close();
    }

}