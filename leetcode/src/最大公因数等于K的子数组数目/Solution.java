package 最大公因数等于K的子数组数目;




class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (func(nums, i, j, k)) {
                    count++;
                } else {
                    break;
                }

            }
        }
        return 0;
    }
    private boolean func(int[] arr, int i, int j, int target) {


        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = new int[]{9,3,1,2,6,3};
        int target1 = 3;
        int[] arr2 = new int[]{4};
        int target2 = 7;
        int result = solution.subarrayGCD(arr1, target1);
        System.out.println(result);
    }
}