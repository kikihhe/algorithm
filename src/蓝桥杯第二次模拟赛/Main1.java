package 蓝桥杯第二次模拟赛;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-11-25 11:11
 */
public class Main1 {
    public static void main(String[] args) {
        for(int i = 2022; ; i++) {
            String str = Integer.toBinaryString(i);
            System.out.println(i + " " + str);
//            if(process(str)) {
//                System.out.println(i + " " + str);
//                break;
//            }
        }
    }
    // 判断最低的6位是否全为0
    private static boolean process(String str) {
        char[] arr = str.toCharArray();
        int count = 0;
        int i = arr.length - 1;
        while(count < 6) {
            if(arr[i] != '0') {
                return false;
            } else {
                i--;
                count++;
            }

        }
        return true;
    }
}
