package 输入工具类;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-11-21 11:10
 */
import java.io.*;
import java.util.*;


/**
 * @Author DragonOne
 * @Date 2021/12/5 21:27
 * @墨水记忆 www.tothefor.com
 */
public class Main {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StreamTokenizer cin = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter cout = new PrintWriter(new OutputStreamWriter(System.out));
    public static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) throws Exception {
        int min = 2147483647;
        int minSize = 0;
        int max = 0;
        int maxSize = 0;
        int n = nextInt();
        for (int i = 0; i < n; i++) {
            int score = nextInt();
            if(min == score) minSize++;
            if(max == score) maxSize++;
            if(score < min) {
                min = score;
                minSize = 1;
            } else if(score > max) {
                max = score;
                maxSize = 1;
            }
        }
        System.out.println(min + " " + minSize);
        System.out.println(max + " " + maxSize);
//         closeAll();
    }


    public static int nextInt() throws Exception {
        cin.nextToken();
        return (int) cin.nval;
    }

    public static long nextLong() throws Exception {
        cin.nextToken();
        return (long) cin.nval;
    }

    public static double nextDouble() throws Exception {
        cin.nextToken();
        return cin.nval;
    }

    public static String nextString() throws Exception {
        cin.nextToken();
        return cin.sval;
    }

    public static void closeAll() throws Exception {
        cout.close();
        in.close();
        out.close();
    }

}
