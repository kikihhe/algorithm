package study;

import java.util.Scanner;

/**
 学长给你指定了一个学习计划，考虑到计算机的本质是个二进制，
 所以你将在2^1天内每天刷一题，2^2天内每天刷两题,即第1,2天每天刷一题，第3到6天每天刷两题，
 2^x天每天刷x题,以此类推，有算法基础的你决定写一个程序来看看自己在规定的天数内到底要写几道题

 */
public class Test1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int dayCount = 1;// 每天做多少题?1、2、3、、、
        int day = 1;//二进制，每次向右<<2, 使用总天数减去他就得到一个做题区间，例如做2道题的共有4天
        int result = 0; // 做的总题数
        while (x > 0) {
            day <<= 1;
            result += dayCount * Math.min(day,x);
            x -= Math.min(day, x);
            dayCount++;
        }
        System.out.println(result);

    }
}
