package 每日温度;

import java.util.Arrays;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int j = i + 1;
            while (j < temperatures.length && temperatures[j] <= temperatures[i]){
                j++;

            }
            if(j == temperatures.length ) {
                result[i] = 0;
            } else{
                result[i] = j - i;
            }

        }
        return result;

    }

    public static void main(String[] args) {
//        Solution s = new Solution();
//        int[] arr = new int[] {73,74,75,71,69,72,76,73};
//
//        int[] ints = s.dailyTemperatures(arr);
//        System.out.println(Arrays.toString(ints));
    }
}