package 部落;

import java.util.*;
public class Main {
    private static void process(List<Set<Integer>> list, int[] P) {
        boolean flag = false;
        // 遍历该数组中所有值，如果不存在，创建新的部落
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < P.length; j++) {
                if(list.get(i).contains(P[j])) {
                    // 如果存在，将本数组中其他值加进去
                    for (int y = 0; y < P.length; y++) {
                        list.get(i).add(P[y]);
                    }
                   flag = true;
                }
            }

        }
        // 如果不存在，创建新的部落
        if (!flag) {
            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < P.length; i++) {
                set.add(P[i]);
            }
            list.add(set);

        }


    }
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Set<Integer>> list = new ArrayList<>();
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int K = scanner.nextInt();
            int[] P = new int[K];
            for (int j = 0; j < K; j++) {
                P[i] = scanner.nextInt();
            }
            process(list, P);
        }

    }
}