package 消掉ACM;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-05-04 20:03
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String target = "ACM";
        // 消掉所有 "ACM"
        while (true) {
            int pos = str.indexOf(target);
            // 如果没找到，证明没有了
            if (pos == -1) {
                break;
            } else {
                str = str.replaceFirst(target, "");
            }
        }
        if (str.length() == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
