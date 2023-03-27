package 吃鱼还是吃肉;

import java.util.*;
public class Main {
    // Ahigh代表标准身高, Aheight代表标准体重
    // high代表当前人的身高, height代表当前人的体重
    public static void process(int Ahigh, int Aheight, int high, int height) {
        if (high < Ahigh) {
            System.out.print("duo chi yu!");
        } else if (high > Ahigh) {
            System.out.print("ni li hai!");
        } else {
            System.out.print("wan mei!");
        }
        if (height < Aheight) {
            System.out.print(" duo chi rou!");
        } else if (height > Aheight) {
            System.out.print(" shao chi rou!");
        } else {
            System.out.print(" wan mei!");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int sex = scanner.nextInt();
            int high = scanner.nextInt();
            int height = scanner.nextInt();
            // 男 身高130 体重27
            // 女 身高129 体重25
            if (sex == 1) {
                // 男
                process(130, 27, high, height);
            } else {
                process(129, 25, high, height);
            }
        }
    }
}