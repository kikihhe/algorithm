package 颜色分类;

class Solution {
    public void sortColors(int[] nums) {
        // 一身反骨直接排序
        // Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        int i = 0; 
        int j = nums.length - 1;
        int t = 0;
        int a = 0;
        while(a <= j) {
            if (a < i) {
                while(a < i) {
                    a++;
                }
            }
            // 如果该数为0，放在最左边。
            if(nums[a] == 0) {
                t = nums[i];
                nums[i] = nums[a];
                nums[a] = t;
                i++;
            } else if (nums[a] == 2) {
                // 如果数字为2，放在最右边
                t = nums[j];
                nums[j] = nums[a];
                nums[a] = t;
                j--;
            } else {
                a++;
            }
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.sortColors(new int[]{0,2,1});
    }
}