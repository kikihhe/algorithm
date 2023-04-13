package 作业.作业五;

import java.util.Scanner;

public class PascalTriangle {

    // A recursive function to calculate factorial
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // A function to print Pascal's triangle up to n lines
    public static void printPascal(int n) {
        // Iterate over each row
        for (int i = 0; i < n; i++) {
            // Print spaces for left alignment
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            // Print each value in the row using nCr formula
            for (int k = 0; k <= i; k++) {
                System.out.print(" " + factorial(i) / (factorial(i - k) * factorial(k)));
            }
            // Move to the next line
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Test
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of lines to print");
        int n = scanner.nextInt();
        printPascal(n);
    }
}