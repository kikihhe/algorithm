package 字符串中连续最大数字字串;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        int flag = 0;
        int count = 0;
        int max = 0;
        Scanner s = new Scanner(System.in);
        String str = s.next();
        char[] arr = str.toCharArray();
        int i = 0;
        while(i < arr.length) {
            count = 0;
            while (i < arr.length && (arr[i] >= '0' && arr[i] <= '9')) {
                count++;
                i++;
            }
            if (count >= max) {
                flag = i;
            }
            max = Math.max(max, count);
            i++;
            
        }
        System.out.println(str.substring(flag - max,flag));
        
        
    }
}