package 点赞;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] map = new int[10005];
        int N = s.nextInt();
        for (int i = 0; i < N; i++) {
            int K = s.nextInt();
            for (int j = 0; j < K; j++) {
                map[s.nextInt()]++;

            }
        }
        int max = 0;
        int index = 0;
        for (int i = 0; i < map.length; i++) {
            if(map[i] >= max) {
                max = map[i];
                index = i;
            }
        }
        System.out.println(index + " " + map[index]);
    }
}