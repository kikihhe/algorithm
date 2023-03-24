package 移动零;

import java.util.Arrays;

class Solution {
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void moveZeroes(int[] arr) {
        if(arr == null || arr.length == 1) return ;

        int i = arr.length-1;
        int j = arr.length-1;
        while(i > 0) {
            while(i >= 0 && arr[i] != 0) {
                i--;
            }
            if (i < 0)  {
//                System.out.println(Arrays.toString(arr));
                return;
            }
            while(i >= 0 && i < j) {
                swap(arr, i, i+1);
                i++;
            }
            j--;
            i=j;
        }


    }

    public static void main(String[] args) {
        Solution solution = new Solution();
       solution.moveZeroes(new int[]{0, 1, 0, 3, 12});

    }
}