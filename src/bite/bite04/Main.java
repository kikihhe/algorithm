package bite.bite04;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int n4 = in.nextInt();

        int A = (n1 + n2) / 2;
        int B = n3 - A;
        if ((n2 + n4)/2 == B) {
            System.out.println(A + " " + B + " ");
        }

    }
}