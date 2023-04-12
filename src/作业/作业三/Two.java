package 作业.作业三;

        import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter a string: ");
                String input = scanner.nextLine().toLowerCase();
                int vowelA = 0;
                int vowelE = 0;
                int vowelI = 0;
                int vowelO = 0;
                int vowelU = 0;
                int nonVowelCount = 0;

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
