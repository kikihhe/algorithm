package 作业.作业四;

import java.util.Scanner;

public class BugDriver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter initial position: ");
//        Enter an initial subscript
        int initialPosition = input.nextInt();
//        Create a Bug based on the subscript
        Bug bug = new Bug(initialPosition);

        boolean done = false;
        while (!done) {
            System.out.print("(M)ove, (T)urn, (O)utput, (E)xit: ");
            String command = input.next();
            if (command.equalsIgnoreCase("M")) {
                bug.move();
            } else if (command.equalsIgnoreCase("T")) {
                bug.turn();
            } else if (command.equalsIgnoreCase("O")) {
                System.out.println(bug.toString());
            } else if (command.equalsIgnoreCase("E")) {
                done = true;
            }
        }
    }
}