package com.xiaohe.树.是否为对称二叉树;


//Definition for a binary tree node.
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

    /**
     * 解题思路 : 判断左孩子的右孩子 与 右孩子的左孩子是否相等
     */
    public boolean checkSymmetricTree(TreeNode root) {
        if (root == null) return true;
        return process(root.left, root.right);
    }

    public boolean process(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.val != b.val) {
            return false;
        }

        return process(a.left, b.right) && process(a.right, b.left);
    }
}