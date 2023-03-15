package 猜数字;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String[] name = new String[N];
        int[] score = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            name[i] = scanner.next();
            score[i] = scanner.nextInt();
            sum += score[i];
        }
        double avg = sum*1.0 / N / 2;
        int index = get(score, avg);
        System.out.println((int)avg + " " + score[index]);
        
    }
    public static int get(int[] score, double avg) {
        
        double minSub = 100;
        int index = 0;
        for (int i = 0; i < score.length; i++) {
            double sub = Math.abs(score[i] - avg);
            if(sub < minSub) {
                index = i;
                minSub = sub;
            }
        }
        return index;
    }
}