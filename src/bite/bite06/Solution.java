package bite.bite06;

class Solution {
    public static boolean sumOfNumberAndReverse(int num) {
        for (int i = 0; i < num; i++) {
            int reverse = reverse(i);
            if (reverse + i == num) return true;
        }
        return false;
    }
    public static int reverse(int num) {
        String reverse = new StringBuffer((num + "")).reverse().toString();
        while(reverse.length() != 0 && reverse.charAt(0) == '0') {
            reverse = reverse.substring(1,reverse.length());
        }
        if (reverse.length() == 0) return 0;
        return Integer.parseInt(reverse);
    }

    public static void main(String[] args) {
        System.out.println(sumOfNumberAndReverse(63));
    }

}