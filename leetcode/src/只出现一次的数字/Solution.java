package 只出现一次的数字;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-04-02 17:14
 */
public class Solution {
    public int singleNumber(int[] arr) {
        // 找数组中只出现了一次的数字，其他数都出现了3次
        // 统计这些数的每一个二进制位都出现了多少次
        int[] bit = new int[32];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 32; j++) {
                int x = arr[i] >> (31-j);
                bit[j] += (x) & 1;
            }
        }

        // 将每一位%3，余下的值就是答案的每一位
        String a = "";
        for (int i = 0; i < 32; i++) {
            bit[i] %= 3;
            a += bit[i];
        }
        int result = Integer.parseInt(a, 2);


        return result;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Integer.toBinaryString(100));
        int[] arr = new int[]{3,1,3,1,3,1,100};
        int i = solution.singleNumber(arr);
        System.out.println(i);
    }
}