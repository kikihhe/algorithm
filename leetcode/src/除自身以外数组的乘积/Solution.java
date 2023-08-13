package 除自身以外数组的乘积;

import java.util.Arrays;

class Solution {
    public int[] productExceptSelf(int[] arr) {
        // 前缀积
        int[] a = new int[arr.length + 2];
        // 后缀积
        int[] b = new int[arr.length + 2];
        a[0] = 1;
        for (int i = 1; i < a.length - 1; i++) {
            a[i] = a[i - 1] * arr[i - 1];
        }
        b[b.length-1] = 1;
        for (int i = b.length - 2; i > 0; i--) {
            b[i] = b[i + 1] * arr[i - 1];
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = a[i] * b[i + 2];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {-1,1,0,-3,3};
        int[] result = solution.productExceptSelf(arr);

        System.out.println(Arrays.toString(result));
    }
}