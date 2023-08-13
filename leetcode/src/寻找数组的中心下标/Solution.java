package 寻找数组的中心下标;

class Solution {
    public int pivotIndex(int[] nums) {
        int[] arr1 = new int[nums.length + 2];
        int[] arr2 = new int[nums.length + 2];

        for (int i = 1; i < arr1.length - 1; i++) {
            arr1[i] = nums[i - 1] + arr1[i - 1];
        }


        for (int i = arr2.length - 2; i > 0; i--) {
            arr2[i] = arr2[i + 1] + nums[i - 1];
        }

        for (int i = 1; i < arr1.length - 1; i++) {
            if (arr1[i - 1] == arr2[i + 1]) {
                return i - 1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1,-1,2};
        int index = solution.pivotIndex(arr);
        System.out.println(index);
    }
}