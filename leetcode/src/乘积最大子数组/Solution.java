package 乘积最大子数组;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-03-23 20:51
 */
class Solution {
    public int maxProduct(int[] arr) {
        int[] dpMax = new int[arr.length];
        int[] dpMin = new int[arr.length];
        int result = arr[0];
        dpMax[0] = arr[0];
        dpMin[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dpMax[i] = Math.max(arr[i], Math.max(dpMax[i-1] * arr[i], dpMin[i-1] * arr[i]));
            dpMin[i] = Math.min(arr[i], Math.min(dpMin[i-1] * arr[i], dpMax[i-1] * arr[i]));
            result = Math.max(dpMax[i], result);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {-2,-5,-1};
        int i = s.maxProduct(arr);
        System.out.println(i);
    }
}
