package 敲笨钟;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < N; i++) {
            String str = scanner.nextLine();
            String[] strs = str.split(",");
            // strs[0] 上半句
            // strs[1] 下半句
            if (strs[0].endsWith("ong") && strs[1].endsWith("ong.")) {
                // 符合规范，将下半句的后三个字替换为qiao ben zhong.
                System.out.print(strs[0] + ",");
                String a = replaceQ(strs[1]);
                System.out.println(a);
            } else {
                System.out.println("Skipped");
            }
        }
        
    }
    
    public static String replaceQ(String strs1) {
        String[] str2 = strs1.split(" ");
        str2[str2.length-1] = "zhong.";
        str2[str2.length-2] = "ben";
        str2[str2.length-3] = "qiao";
        String result = "";
        for (int i = 0; i < str2.length; i++) {
            result += str2[i];
            if (i != str2.length-1) {
                result += " ";
            }
        }
        return result;
    }
}