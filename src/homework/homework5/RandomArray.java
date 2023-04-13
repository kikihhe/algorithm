package homework.homework5;

import java.util.Random;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-04-13 09:56
 */
public class RandomArray {
    private int[] arr;
    private int sum;
    private int min ;
    private int max = -1;
    private static Random random = new Random();
//  At initialization, the maximum value, minimum value, and sum of all the elements of the array are evaluated
    public RandomArray(int length) {
        arr = new int[length];
        min = length;
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(length);
            sum += arr[i];
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

    }

    public int getMin() {
        return min;
    }
    public int getMax() {
        return max;
    }
    public double getAvg() {
        return sum * 1.0 / arr.length;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i] + " ";
        }
        return str;
    }

    public static void main(String[] args) {
        RandomArray randomArray = new RandomArray(10);
        System.out.println(randomArray);

        System.out.println(randomArray.getMin());
        System.out.println(randomArray.getMax());
        System.out.println(randomArray.getAvg());
    }

}
