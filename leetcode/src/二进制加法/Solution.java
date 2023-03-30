package 二进制加法;

import java.math.BigInteger;

class Solution {
    public String addBinary(String a, String b) {
        BigInteger g = new BigInteger(a, 2);
        BigInteger h = new BigInteger(b, 2);
        BigInteger add = g.add(h);
        return add.toString(2);


    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String s = solution.addBinary("1011", "0101");
        String s = solution.addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011");
        System.out.println(s);
    }
}