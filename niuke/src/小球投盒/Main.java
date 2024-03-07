package 小球投盒;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 输入的n, m
        int n = sc.nextInt(), m = sc.nextInt();
        // 使用 HashSet 存储整数集合
        Set<Integer> set = new HashSet<>();
        // 初始化 set 包含从 1 到 n 的所有整数
        for (int i = 1; i <= n; i++) set.add(i);
        // 循环计数变量
        int i;
        for (i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 1) {
                // 如果输入为 1,移除下一个输入的整数
                set.remove(b);
                // 如果集合为空，退出循环
                if (set.isEmpty()) break;
            } else {
                // 如果集合中不包含 x，退出循环
                if (!set.contains(b)) break;
                // 否则，重置集合并添加 x
                set = new HashSet<>();
                set.add(b);
            }
        }
        // 输出结果，如果 i 大于 m，输出 -1，否则输出 i
        System.out.println(i > m ? -1 : i);
    }
}