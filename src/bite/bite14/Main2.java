package bite.bite14;

import java.util.Arrays;
import java.util.Scanner;


public class Main2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();

        }
        Arrays.sort(arr);
        System.out.println(process(arr, 0, 0, 1));




    }
    private static int process(int[] arr, int index, int sum, int mul) {
        int count = 0;
        for (int i = index; i < arr.length; i++) {
            sum += arr[i];
            mul *= arr[i];
            if (sum > mul) {
                count = count + 1 + process(arr, i + 1, sum, mul);
            } else if(arr[i] == 1) {
                count += process(arr, i + 1, sum, mul);
            } else {
                break;
            }
            sum -= arr[i];
            mul /= arr[i];
            while(i < arr.length - 1 && arr[i] == arr[i+1]) {
                i++;
            }
        }
        return count;
    }

}
