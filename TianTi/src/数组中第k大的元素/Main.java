package 数组中第k大的元素;


import java.util.Random;

public class Main {
    private Random random = new Random();

    private int getKey(int[] arr, int left, int right) {
        return arr[random.nextInt(right - left + 1) + left];
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int findK(int[] arr, int l, int r, int k) {
        if(l == r) return arr[l];

        int key = getKey(arr, l, r);
        int left = l - 1;
        int right = r + 1;
        int i = l;
        while (i < right) {
            if (arr[i] < key) {
                swap(arr, i++, ++left);
            } else if (arr[i] == key) {
                i++;
            } else {
                swap(arr, i, --right);
            }
        }
        // 开始区分, 此时的数组已经被分为 : [l, left] [left + 1, right - 1] [right, r]
        // 如果k的数量
        int a = left - l + 1;
        int b = right - 1 - left;
        int c = r - right + 1;

        if (c >= k) {
            return findK(arr, right, r, k);
        } else if (b + c >= k) {
            return key;
        } else {
            return findK(arr, l, left, k - b - c);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = new Main().findK(arr, 0, arr.length - 1, 4);
        System.out.println(k);
    }



}
