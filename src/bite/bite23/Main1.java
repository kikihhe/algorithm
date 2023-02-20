package bite.bite23;


/**
 * @author : 小何
 * @Description :
 * @date : 2022-11-11 09:52
 */
public class Main1 {
    public int getValue(int[] gifts, int n) {
        int[] map = new int[100005];
        int max = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            map[gifts[i]]++;
            if (map[gifts[i]] >= max) {
                max = map[gifts[i]];
                index = gifts[i];
            }
        }
        if (max < (n >> 1)) {
            return 0;
        } else {
            return index;
        }
    }
    // [1,2,3,2,2],5
    // [1,1,2,2,3,3],6

    public static void main(String[] args) {
        Main1 m = new Main1();
        int[] arr = {1,1,2,2,3,3};
        int value = m.getValue(arr, arr.length);
        System.out.println(value);
    }
}
