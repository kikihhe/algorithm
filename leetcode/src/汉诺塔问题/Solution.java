package 汉诺塔问题;

import java.util.List;

public class Solution {
    // 将A处的盘子放在C处（B处为辅助地点）
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        process(A, B, C, A.size());

    }
    // A : 原处
    // B : 辅助
    // C : 目的地 
    // n : 剩余的盘子
    public void process(List<Integer> A, List<Integer> B, List<Integer> C, int n) {
        // 如果还剩一个盘子，直接将它放置在C
        if (n == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }
        // 如果还有好多盘子
        // 1. 将A处 除最下面那个盘子以外的所有盘子 移到B处，(C为辅助)
        process(A, C, B, n - 1);

        // 2. 将A处 最下面的盘子移到C处
        C.add(A.remove(A.size() - 1));

        // 3. 将B处 除最下面那个盘子以外的所有盘子 移到C处，A为辅助
        process(B, A, C, n - 1);
    }
}