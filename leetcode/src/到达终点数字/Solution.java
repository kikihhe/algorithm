package 到达终点数字;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.reachNumber(2);
        System.out.println(i);
    }
    public int reachNumber(int target) {
        // 在第0处想到达第target处

        return process( 0,  target, 1);

    }
    // current: 当前所处位置
    // target: 想要到达的位置
    // i: 现在移动了几步
    private int process(int current, int target, int i) {
        if (current == target) {
            // 到达目标地点
            return i;
        }
        // 没到达目标地点
        int result1 = 0;
        int result2 = 0;
        // 如果两者差距小于i，那就只能向左走拉大距离
        if (Math.abs(current - target) < i) {
            result1 = process(current - i, target, i+1);
        }
        // 如果两者差距大于i，尽量向右走拉小距离
        if (Math.abs(current - target) >= i) {
            result2 = process(current+i, target, i+1);
        }
        return Math.min(result1, result2);
    }
}