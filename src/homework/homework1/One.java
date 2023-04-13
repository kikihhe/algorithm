package homework.homework1;

import java.util.Scanner;


public class One {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the weight: ");
        double a = scanner.nextDouble();
        System.out.println();
        double b = a * 0.45359237;
        System.out.println(b);
    }

}
