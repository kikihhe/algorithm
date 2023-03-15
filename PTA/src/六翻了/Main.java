package 六翻了;

import java.util.*;
public class Main {
    public static int getSixNum(String str, int i) {
        int count = 0;
        while(i < str.length() && str.charAt(i) == '6') {
            count++;
            i++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '6') {
                int count = 0;
                count = getSixNum(str, i);
                if (count > 9) {
                    str = str.substring(0,i) + "27" + str.substring(i+count, str.length());
                } else if (count > 3) {
                    str = str.substring(0,i) + "9" + str.substring(i+count, str.length());
                }
            }


        }
        System.out.println(str);
    }
}