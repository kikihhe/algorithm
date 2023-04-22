package 正式.T6;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-04-22 14:00
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result = scanner.next();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            // 操作的第一个位置
            int begin = scanner.nextInt() - 1;
            // 操作的第二个位置
            int end = scanner.nextInt();
            String jianqie = result.substring(begin, end);
            String qian = scanner.next();
            String hou = scanner.next();
            result = jian(result, jianqie);
            result = zhaotie(result, jianqie, qian, hou);


        }
        System.out.println(result);
    }

    // 将jianqie从result去掉
    private static String jian(String result, String jianqie) {
        int index = result.indexOf(jianqie);
        result = result.substring(0, index) + result.substring(index+jianqie.length());

        return result;
    }

    private static String zhaotie(String result, String jianqie, String qian, String hou) {
        int indexOfQian = 0;
        int indexOfHou = 0;
        boolean flag = true;
        // 如果没有出现过
        if (!result.contains(qian) || !result.contains(hou)) {
            result += jianqie;
            return result;
        }

        while (indexOfQian < result.length() && indexOfQian >= 0 && indexOfHou >= 0) {
            indexOfQian = result.indexOf(qian, indexOfQian);
            indexOfHou = result.indexOf(hou, indexOfHou);
            if (indexOfQian == -1 || indexOfHou == -1) {
                flag = false;
                break;
            }
            if (indexOfQian == indexOfHou - qian.length()) {

                String hou1 = result.substring(indexOfHou);
                result = result.substring(0, indexOfQian + qian.length()) + jianqie + hou1;
                break;
            } else {
                indexOfQian++;
                indexOfHou++;
            }

        }
        if (!flag) {
            result += jianqie;
        }
        return result;
    }
}
