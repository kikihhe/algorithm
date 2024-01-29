package com.xiaohe.树.计算布尔二叉树的值;

/**
 * @author : 小何
 * @Description :
 * @date : 2024-01-29 15:48
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
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }
        if (root.val == 2) {
            return evaluateTree(root.left) | evaluateTree(root.right);
        } else {
            return evaluateTree(root.left) & evaluateTree(root.right);
        }
    }
}