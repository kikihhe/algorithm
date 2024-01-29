package com.xiaohe.树.二叉搜索树中第K小的元素;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    // k
    public int count = 0;
    // 现在遍历到第几个了
    public int index;
    // 要返回的值
    public int value;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        process(root);
        return value;
    }
    public void process(TreeNode root) {
        if (root == null) {
            return ;
        }
        if (root.left != null) {
            process(root.left);
        }
        index++;
        if (index == count) {
            value = root.val;
            return;
        }
        if (root.right != null) {
            process(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        new Solution().kthSmallest(node1, 1);
    }
}