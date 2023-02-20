package study;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-10-14 08:36
 */
public class KMP {
    public static int index(String str1, String str2) {





        return 0;
    }

    public int[] getNextArray(char[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[arr.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < arr.length) {
            if (arr[i - 1] == arr[cn]) {
                next[i] = ++cn;
                i++;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                // 前一个字符没有相等，cn有没有跳的动
                next[i] = 0;
                i++;
            }
        }
        return next;
    }


}
