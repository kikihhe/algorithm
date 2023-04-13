package homework.homework1;

import java.util.Scanner;


public class Two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the seconds: ");
        int seconds = scanner.nextInt();

        // hour = seconds / 3600
        int  hour= (seconds/(60*60));

        // min = (seconds - hour * 3600) / 60
        int min = ((seconds-hour*3600)/60) ;

        seconds %= 60;
        System.out.println(hour + ":" + min + ":" + seconds);
    }
}
