import java.util.Scanner;
import java.util.Random;

public class numbergame {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random ran = new Random();
        int min = 1;
        int max = 100;
        int Limit = 7;
        int rounds = 0;
        int score = 0;
        

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between " + min + " and " + max + ".");

        boolean playAgain = true;
        while (playAgain) {
            int randomNumber = ran.nextInt(max - min + 1) + min;
            int attempts = 0;
            boolean guessedCorrectly = false;

            while (!guessedCorrectly && attempts < Limit) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "): ");
                int userGuess = s.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number " + randomNumber + " correctly in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    score += attempts;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all " + Limit + " attempts. The number was " + randomNumber + ".");
            }

            rounds++;
            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = s.next().toLowerCase();
            playAgain = playChoice.equals("yes");
        }

        System.out.println("Game is Over!");
        System.out.println("Total number of Rounds Played: " + rounds);
        System.out.println("Your Score is: " + score);

        s.close();

    }
}
