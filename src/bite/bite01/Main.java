package bite.bite01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str1 = s.nextLine();
        String str2 = s.nextLine();
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        // str1中出现的str2中的内容下标都会在此处显示
   
        int[] flag = new int[str1.length()];
        for (int i = 0; i < arr1.length; i ++) {
            for (int j = 0; j < arr2.length; j ++) {
                if (arr1[i] == arr2[j]) {
                    flag[i]++;
                    break;
                }
            }
        }
        for (int i = 0; i < arr1.length; i++) {
            if (flag[i] == 0) {
                System.out.print(arr1[i]);
            }
        }
    }
}