package com.xiaohe.树.验证二叉搜索树;


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

class Solution {
    private int pre = Integer.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean left = isValidBST(root.left);
        boolean cur = false;
        if (root.val > pre) {
            cur = true;
        }
        pre = root.val;
        boolean right = isValidBST(root.right);
        return left && cur && right;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
        new Solution().isValidBST(node1);
    }
}