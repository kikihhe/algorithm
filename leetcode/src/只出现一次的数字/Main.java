package 只出现一次的数字;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-03-03 12:51
 */
public class Main {
    public static void main(String[] args) {
        int answer = 0;
        int[] nums = new int[]{1,2,3,4,5,4,3,2,1};
        for (int i = 0; i < nums.length; i++) {
            answer ^= nums[i];
        }
        System.out.println(answer);
    }
}
