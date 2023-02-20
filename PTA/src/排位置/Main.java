package 排位置;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-01-07 20:30
 */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        String str = s.next();
        System.out.println(new Main().solution(N, str));
    }
    public int solution(int N, String str) {
        if (N <= 3) return 0;
        int boy = 0;
        int girl = 0;
        for (char t : str.toCharArray()) {
            if (t == 'F')  girl++;
            else  boy++;
        }
        str += str;
        char[] arr = str.toCharArray();

        int max = 1;
        char marC = 'F';
        for (int i = 0; i < N - 1; i++) {
            int count = 1;
            while(i < N && arr[i] == arr[i+1]) {
                count++;
                i++;
            }
            if (count >= max) {
                max = count;
                marC = arr[i];
            }

        }
        int result = 0;
        if (marC == 'F') {
            result = girl - max;
        } else
            result = boy - max;

        return result;

    }
}
