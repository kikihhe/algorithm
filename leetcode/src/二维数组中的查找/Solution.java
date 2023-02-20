package 二维数组中的查找;

class Solution {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int n = matrix.length;
        int m = matrix[0].length;
        
        int i = n-1;
        int j = 0;
        while(i >= 0 && j < m) {
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] > target) {
                i--;
                continue;
            }
            if (matrix[i][j] < target) {
                j++;
                continue;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] arr = new int[][]{{5}};
        System.out.println(s.findNumberIn2DArray(arr, -18));
    }
}