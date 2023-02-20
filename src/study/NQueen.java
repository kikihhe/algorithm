package study;


/**
 * N皇后问题
 */
public class NQueen {
    /**
     * 未优化的N皇后问题
     * @param i 现在为第几行
     * @param records 已经放过的所有皇后
     * @param n 考察的是几皇后问题
     * @return 返回N皇后问题一共有多少种摆放方法
     */
    public static int process1(int i, int[] records, int n) {
        if (i == n) {
            return 1;
        }
        int result = 0;
        // j代表第几列
        for (int j = 0; j < n; j ++) {
            // 如果此处能放皇后
            if (isValid(records,i, j)) {
                // 在第i行第j列放一个皇后
                records[i] = j;
                result += process1(i + 1,records, n);
            }
        }
        return result;
    }

    /**
     * 判断第i行第j列是否能放皇后
     * @param records 已经放过的所有皇后
     * @param i 此时在第i行
     * @param j 此时在第j列
     * @return
     */
    public static boolean isValid(int[] records, int i, int j) {
        // 已经有i行放有皇后，故从0遍历到i，不能多遍历
        for (int k = 0; k < i; k ++) {
            if (j == records[k] || Math.abs(records[k]-j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int sqrt = (int)Math.sqrt(5);
        System.out.println(sqrt);
    }

}
