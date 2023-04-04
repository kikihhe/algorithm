package 悄悄关注;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        // 关注列表
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(scanner.next());
        }
        // 开始统计点赞人数
        int x = scanner.nextInt();
        String[] names = new String[x];
        int[] count = new int[x];
        // 所有点赞数量
        int all = 0;
        for (int i = 0; i < x; i++) {
            names[i] = scanner.next();
            count[i] = scanner.nextInt();
            all += count[i];
        }
        int avg = all / x;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            if (count[i] > avg && !set.contains(names[i])) {
                result.add(names[i]);
            }
        }
        if (result.size() == 0) {
            System.out.println("Bing Mei You\n");
        } else {
            result.sort(null);
            for(String str : result) {
                System.out.println(str);
            }

        }

    }
}