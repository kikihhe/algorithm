package 客似云来;// write your code here
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long[] arr = new long[81];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 2;
        for (int i = 4; i < arr.length; i++) {
            arr[i] = arr[i-2] + arr[i-1];
        }
        while(scanner.hasNext()) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            long count = 0;
            for (int i = from; i <= to; i++) {
                count += arr[i];
            }
                System.out.println(count);
        }

    }
}