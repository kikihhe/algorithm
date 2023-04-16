package 十;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    // 将 13:00:00 - 18:00:00 样式的时间转换为13, 00, 00, 18, 00, 00
    public static int[] getTime(String str) {
        String[] split = str.split(" - ");
        String[] time1 = split[0].split(":");
        int[] time = new int[6];
        for (int i = 0; i < time1.length; i++) {
            int a = Integer.parseInt(time1[i]);
            time[i] = a;
        }
        String[] time2 = split[1].split(":");
        for (int i = 0; i < time2.length; i++) {
            int a = Integer.parseInt(time2[i]);
            time[i+3] = a;
        }

        int[] result = new int[2];
        int h1 = time[0];
        int h2 = time[1];
        int h3 = time[2];
        result[0] = h1 * 60 * 60 + h2 * 60 + h3;

        int h4 = time[3];
        int h5 = time[4];
        int h6 = time[5];
        result[1] = h4 * 60 * 60 + h5 * 60 + h6;
        return result;
    }


//    public static int[] getHMS(int[] time) {
//        int[] result = new int[2];
//        int h1 = time[0];
//        int h2 = time[1];
//        int h3 = time[2];
//        result[0] = h1 * 60 * 24 + h2 * 60 + h3;
//
//        int h4 = time[3];
//        int h5 = time[4];
//        int h6 = time[5];
//        result[1] = h4 * 60 * 24 + h5 * 60 + h6;
//        return result;
//    }
    // 这是一个秒数，将其转化为时间，并以 hh:mm:ss 的格式返回
    public static String process(int time) {
        int second = time % 60;
        int min = time / 60 % 60 ;
        int hour = time / (60 * 60) % 24;

        String h = hour + "";
        String m = min + "";
        String s = second + "";
        if (hour < 10) {
            h = "0" + h;
        }
        if (min < 10) {
            m = "0" + m;
        }
        if (second < 10) {
            s = "0" + s;
        }
        return h + ":" + m + ":" + s;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean[] time = new boolean[86400];
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String str = scanner.nextLine();
            int[] timeSecond = getTime(str);
            // timeSecond: 第几秒
//            int[] timeSecond = getHMS(time1);
            for (int j = timeSecond[0]; j < timeSecond[1]; j++) {
                time[j] = true;
            }
        }

        // 通过time[] 数组中不为true的秒数筛选时间
        List<String> list = new ArrayList<>();
        for (int i = 0; i < time.length; i++) {
            if (time[i]) {
                continue;
            } else {
                int begin = i;
                for (int j = i; j < time.length; j++) {
                    if (time[j]) {
                        i = j;
                        break;
                    }
                    else {
                        i = j;
                    }
                }
                int end = i;
                list.add(process(begin));
                list.add(process(end));
            }


        }
//        System.out.println(list);
        for (int i = 0; i < list.size(); i ++) {
            System.out.print(list.get(i) + " - " );

            System.out.print(list.get(++i));
            if (i != list.size() - 1) {
                System.out.println();
            }
        }


    }
}
