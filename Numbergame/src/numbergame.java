import java.util.Scanner;
import java.util.Random;

public class numbergame {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        final Random ra = new Random();
        int minRange=1;
        int maxRange=100;
        int Limit=7;
        int rounds=0;
        int score=0;

        System.out.println("Welcome to the number guessing game!");
        System.out.println("Guess a number between"+minRange+"and"+maxRange);
        boolean playAgain=true;
        while(playAgain){
            int randomNumber=ra.nextInt(maxRange-minRange+1)+minRange;
            int attempts=0;
            boolean guessCorrect=false;
            while(!guessCorrect && attempts < Limit){
                System.out.println("Enter your guess(Attempt" +(attempts +1) +"):");
                int userGuess=sc.nextInt();
                attempts++;
                if (userGuess==randomNumber){
                    System.out.println("Congratulations! You guessed the number "+randomNumber+" correctly in "+attempts+" attempts");
                    guessCorrect=true;
                    score+=attempts;
                }else if(userGuess<randomNumber){
                    System.out.println("Too low!");
                }else{
                    System.out.println("Too high!");
                }
            }
            if (!guessCorrect){
                System.out.println("Sorry, you've used all"+ Limit+"attempts. The number was"+randomNumber+".");
            } 
            rounds++;
            System.out.println("Do you want to play again? (yes/no):");
            String playChoice=sc.next().toLowerCase();
            playAgain=playChoice.equals("yes");       
        }
        System.out.println("Game Over!");
        System.out.println("Total Rounds Played:"+rounds);
        System.out.println("Your Score:"+score);
    }
}
