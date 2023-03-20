package 一帮一;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        // arr的下标代表排名，从1到N
        // arr[i]代表他分到的人的排名
        // sex[i]代表第i位人的性别
        // is[i]第i位是否已经被选
        int[] arr = new int[N + 1];
        int[] sex = new int[N + 1];
        boolean[] is = new boolean[N+1];
        String[] name = new String[N + 1];
        for (int i = 1; i < N + 1; i++) {
            sex[i] = scanner.nextInt();
            name[i] = scanner.next();
        }
        // 开始检索
        for (int i = 1; i <= N; i++) {
            // 如果这个人没有被选, 从后往前开始选
            if (!is[i]) {
                for (int j = N; j >= 0; j--) {
                    // 如果这个人已经被选,跳过
                    if (is[j]) continue;
                    if (sex[i] != sex[j]) {
                        is[i] = true;
                        is[j] = true;
                        arr[i] = j;
                        arr[j] = i;
                        break;
                    }
                }
            }
        }
        for (int i = 1; i <= N / 2; i++) {
            System.out.println(name[i] + " " + name[arr[i]]);
        }
    }
}