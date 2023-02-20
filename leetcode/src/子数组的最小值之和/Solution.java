package 子数组的最小值之和;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-10-29 09:49
 */
public class Solution {
    private final double mod = 1E9 + 7;
    public int sumSubarrayMins(int[] arr) {
        double sum = 0;
        for(int i = 0; i < arr.length; i++) {
            int min = arr[i];
            for (int j = i; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                sum += min;
            }
        }

        return (int)(sum % mod);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{11,81,94,43,3};
        int result = s.sumSubarrayMins(arr);
        System.out.println(result);
    }
}
