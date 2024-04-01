package com.xiaohe.树.二叉树的最大宽度;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : 小何
 * @Description :
 * @date : 2024-04-01 20:24
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    /**
     * 对于以下这棵树 :
     *           1
     *        /    \
     *      3        2
     *    /   \        \
     *  5      6         9
     *  题目只让求最大宽度，我们可以将节点的值更改为 节点在该层中的下标
     *  下标从0开始，比如 2 的下标为 1，它的右节点 9 的下标为 2 * 1 + 1
     *  leftChildIndex = parentIndex * 2
     *  rightChildIndex = parentIndex * 2 + 1
     *  在计算每一层的宽度时，只需要从队列中找出第一个节点和最后一个节点，使用 index 相减。
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int max = 1;
        Deque<TreeNode> queue = new LinkedList<>();
        root.val = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int currentWidth = queue.peekLast().val - queue.peekFirst().val + 1;
            max = Math.max(max, currentWidth);
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    TreeNode left = poll.left;
                    left.val = poll.val * 2;
                    queue.offer(left);
                }
                if (poll.right != null) {
                    TreeNode right = poll.right;
                    right.val = poll.val * 2 + 1;
                    queue.offer(right);
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        TreeNode node6 = new TreeNode(1, null, null);
        TreeNode node5 = new TreeNode(3, null, null);
        TreeNode node4 = new TreeNode(5, null, null);
        TreeNode node3 = new TreeNode(2, null, node6);
        TreeNode node2 = new TreeNode(3, node4, node5);
        TreeNode root = new TreeNode(1, node2, node3);
        System.out.println(new Solution().widthOfBinaryTree(root));
    }
}