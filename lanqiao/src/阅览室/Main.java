package 阅览室;

import java.util.*;
class A {
    public int id;
    public int hour;
    public int min;
    public A(){}
    public A(int id, int hour, int min) {
        this.id = id;
        this.hour = hour;
        this.min = min;
    }
}
public class Main {
    public static int[] getTime(String time) {
        String[] times = time.split(":");
        int hour = Integer.parseInt(times[0]);
        int min = Integer.parseInt(times[1]);
        return new int[]{hour, min};
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        // 每天的借书次数
        int[] g = new int[N];
        // z[i] -> 第i天的总时间
        int[] z = new int[N];
        int i = 0;
        A[] set = new A[1001];

        while (i < N) {

            int count = 0;
            // 操作的书的id
            int id = scanner.nextInt();
            // 进行的操作
            String str = scanner.next();
            // 时间
            String time1 = scanner.next();


            if (id == 0) {
                set = new A[1001];
                i++;
                continue;
            }
            int[] time = getTime(time1);
            // 操作的小时
            int hour = time[0];
            // 操作的分钟
            int min = time[1];

            // 还书
            if ("E".equals(str)) {
                if (set[id] == null)
                    continue;
                else {
                    A a = set[id];
                    int x1 = hour*60 + min;
                    int x2 = a.hour*60 + a.min;
                    // 该书的借阅时间
                    
                    int aa = x1 - x2;
                    z[i] += aa;
                    g[i]++;
                    set[id] = null;
                }
            } else if ("S".equals(str)) {
                // 借书
                set[id] = new A(id, hour, min);

            }
        }

//        System.out.println(Arrays.toString(g));
//        System.out.println(Arrays.toString(z));
        for (int j = 0; j < N; j++) {
            if (g[j] == 0) {
                System.out.println("0 0");
            }else {
                System.out.println(g[j] + " " + (int)(Math.ceil(z[j]*1.0/g[j])));
            }
        }
    }
}