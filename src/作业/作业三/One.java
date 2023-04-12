package 作业.作业三;


import java.util.Scanner;
import java.util.Random;

public class One {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int guessCount = 0;
        boolean playAgain = true;
        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            System.out.println("I'm thinking of a number between 1 and 100.");
            int guess = -1;
            while (guess != numberToGuess) {
                System.out.print("Enter your guess (1-100): ");
                guess = input.nextInt();
                if (guess < 1 || guess > 100) {
                    System.out.println("Your guess is out of range.");
                    continue;
                }
                guessCount++;
                if (guess == numberToGuess) {
                    System.out.println("You guessed it! It took you " + guessCount + " guesses.");
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }
            System.out.print("Do you want to play again? (y/n): ");
            String playAgainStr = input.next();
            if (!playAgainStr.equalsIgnoreCase("y")) {
                playAgain = false;
            }
            guessCount = 0;
        }
    }
}
