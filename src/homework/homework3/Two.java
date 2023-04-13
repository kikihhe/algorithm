package homework.homework3;

        import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter a string: ");
                String input = scanner.nextLine().toLowerCase();
                // Store the number of A/a occurrences
                int vowelA = 0;
                // Store the number of E/e occurrences
                int vowelE = 0;
                // Store the number of I/i occurrences
                int vowelI = 0;
                // Store the number of O/o occurrences
                int vowelO = 0;
                // Number of times the U/u is stored
                int vowelU = 0;
                // Stores the number of occurrences of other characters
                int nonVowelCount = 0;

                // The string is traversed with switch
                for (int i = 0; i < input.length(); i++) {
                    char ch = input.charAt(i);
                    switch (ch) {
                        case 'a':
                            vowelA++;
                            break;
                        case 'e':
                            vowelE++;
                            break;
                        case 'i':
                            vowelI++;
                            break;
                        case 'o':
                            vowelO++;
                            break;
                        case 'u':
                            vowelU++;
                            break;
                        default:
                            nonVowelCount++;
                    }
                }

                System.out.println("Number of A's: " + vowelA);
                System.out.println("Number of E's: " + vowelE);
                System.out.println("Number of I's: " + vowelI);
                System.out.println("Number of O's: " + vowelO);
                System.out.println("Number of U's: " + vowelU);
                System.out.println("Number of non-vowels: " + nonVowelCount);
            }

}
