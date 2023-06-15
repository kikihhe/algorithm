package 四宫格;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-02-28 18:31
 */
public class Main {
    public static void main(String[] args) {

        // arr是MagicSquare
        int[][] arr = new int[][]{
                {16, 2, 3, 13},
                {5, 11, 10, 8},
                {9, 7, 6, 12},
                {4, 14, 15, 1}
        };
        System.out.println(isMagicSquare(arr));

        // arr0是MagicSquare
        int[][] arr0 = new int[][] {
                {1,1,1,1},
                {1,1,1,1},
                {1,1,1,1},
                {1,1,1,1}
        };
        System.out.println(isMagicSquare(arr0));
        // arr1的最后一个元素与arr不一样，不是MagicSquare
        int[][] arr1 = new int[][]{
                {16, 2, 3, 13},
                {5, 11, 10, 8},
                {9, 7, 6, 12},
                {4, 14, 15, 10}
        };
        System.out.println(isMagicSquare(arr1));

    }
    public static boolean isMagicSquare(int[][] arr) {
        int a = 0;
        // 计算第一行的和
        for (int i = 0; i < arr[0].length; i++) {
            a += arr[0][i];
        }
        // 计算每一行的和
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
            if (sum != a) return false;
        }
        // 计算每一列的和
        for (int i = 0; i < arr[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < arr.length; j++) {
                sum += arr[j][i];
            }
            if (sum != a) return false;
        }
        // 计算对角线的和
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < 4; i++) {
            sum1 += arr[i][i];
            sum2 += arr[3-i][3-i];
        }
        if (sum1 != a || sum2 != a) return false;
        return true;
    }
}
