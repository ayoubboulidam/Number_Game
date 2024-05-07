import java.util.Random;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        // Initialize variables
        Random random = new Random();
        int round = 1;
        int bestScore = 8; // Initializing with maximum possible attempts
        int roundWins = 0;
        boolean continueGame = true;

        while (continueGame) {
            StringBuilder message = new StringBuilder();
            message.append("Round ").append(round).append("\n");
            message.append("Round wins: ").append(roundWins).append("\n");
            message.append("Best Score: ").append(bestScore).append("\n\n");
            message.append("You have 8 attempts\nGuess a number between 1 and 100: ");

            // Get user's guess
            int guess = Integer.parseInt(JOptionPane.showInputDialog(message.toString()));

            // Generate random number
            int randomNumber = random.nextInt(100) + 1;

            if (guess == randomNumber) {
                // Correct guess in one attempt
                JOptionPane.showMessageDialog(null, "YOU Guessed the number from one attempt! WOW");
                roundWins++;
            } else {
                // Guessing with multiple attempts
                int attempts = 1;
                while (attempts < 8) {
                    if (guess == randomNumber) {
                        // Correct guess
                        JOptionPane.showMessageDialog(null, "Correct! You guessed the number in " + attempts + " attempts.");
                        roundWins++;
                        if (attempts < bestScore) {
                            bestScore = attempts; // Update best score
                        }
                        break;
                    } else if (guess < randomNumber) {
                        guess = Integer.parseInt(JOptionPane.showInputDialog("Too low. Guess a higher number: "));
                    } else {
                        guess = Integer.parseInt(JOptionPane.showInputDialog("Too high. Guess a lower number: "));
                    }
                    attempts++;
                }
                if (attempts == 8 && guess != randomNumber) {
                    // Too many attempts
                    JOptionPane.showMessageDialog(null, "Too many attempts! The number was " + randomNumber);
                }
            }

            // Ask if user wants to continue
            int option = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Continue", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                continueGame = true;
                round++;
            } else {
                // Game summary
                JOptionPane.showMessageDialog(null, "Total Rounds: " + round + "\nRound wins: " + roundWins + "\nBest Score: " + bestScore);
                continueGame = false;
            }
        }
    }
}
