package com.xiaohe.递归.汉诺塔问题;

import java.util.List;

/**
 * @author : 小何
 * @Description :
 * @date : 2024-01-28 13:07
 */
public class Main {

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A, B, C, A.size());
    }
    // n: A中圆盘的数量
    public void move(List<Integer> A, List<Integer> B, List<Integer> C, int n) {
        if (n == 1) {
            Integer a = A.remove(A.size() - 1);
            C.add(a);
            return;
        }
        move(A, C, B, n - 1);
        C.add(A.remove(A.size() - 1));
        move(B, A, C, n - 1);
    }

}
