import java.util.Random;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        int round = 1;
        int bestScore = 8;
        int roundWins = 0;
        boolean continueGame = true;

        while (continueGame) {
            int guess = Integer.parseInt(JOptionPane.showInputDialog(
                    "Round " + round + "\nRound wins: " + roundWins + "\nBest Score: " + bestScore +
                            "\n\nYou have 8 attempts\nGuess a number between 1 and 100: "
            ));

            int randomNumber = random.nextInt(100) + 1;

            if (guess == randomNumber) {
                JOptionPane.showMessageDialog(null, "YOU Guessed the number from one attempt! WOW");
                roundWins++;
            } else {
                int attempts = 1;
                while (attempts < 8) {
                    if (guess == randomNumber) {
                        JOptionPane.showMessageDialog(null, "Correct! You guessed the number in " + attempts + " attempts.");
                        roundWins++;
                        if (attempts < bestScore) {
                            bestScore = attempts;
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
                    JOptionPane.showMessageDialog(null, "Too many attempts! The number was " + randomNumber);
                }
            }

            int option = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Continue", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                continueGame = true;
                round++;
            } else {
                JOptionPane.showMessageDialog(null, "Total Rounds: " + round + "\nRound wins: " + roundWins + "\nBest Score: " + bestScore);
                continueGame = false;
            }
        }
    }
}
