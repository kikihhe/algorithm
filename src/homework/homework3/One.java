package homework.homework3;


import java.util.Scanner;
import java.util.Random;

public class One {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int guessCount = 0;
        // Flag bit: Whether the game continues
        boolean playAgain = true;
        while (playAgain) {
            // Generate a random number
            int numberToGuess = random.nextInt(100) + 1;
            System.out.println("I'm thinking of a number between 1 and 100.");
            int guess = -1;
            while (guess != numberToGuess) {
                System.out.print("Enter your guess (1-100): ");
                guess = input.nextInt();
                // If you guess a number that does not conform to the specification, that is, 1 &lt; guess || guess &gt; 100, let the user enter again
                if (guess < 1 || guess > 100) {
                    System.out.println("Your guess is out of range.");
                    continue;
                }
                guessCount++;
                // If you are right, the round is over
                if (guess == numberToGuess) {
                    System.out.println("You guessed it! It took you " + guessCount + " guesses.");
                    break;
                } else if (guess < numberToGuess) {
                    // If you guess a smaller number than the answer
                    System.out.println("Too low!");
                } else {
                    // If you guess a larger number than the answer
                    System.out.println("Too high!");
                }
            }
            System.out.print("Do you want to play again? (y/n): ");
            String playAgainStr = input.next();
            // If the user types y, the game starts over
            if (!playAgainStr.equalsIgnoreCase("y")) {
                playAgain = false;
            }
            guessCount = 0;
        }
    }
}
