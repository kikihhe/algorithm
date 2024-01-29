package com.xiaohe.树.二叉树剪枝;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
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
    public TreeNode pruneTree(TreeNode root) {
        return process(root);
    }

    public TreeNode process(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val == 0 ? null : root;
        }
        // 如果左子树可以移除，右子树也可以移除，并且本树.val == 0 就可以移除
        // 如果左子树或右子树中有一个不能移除，那本树就不能移除

        if (root.left != null) {
            root.left = process(root.left);
        }
        if (root.right != null) {
            root.right = process(root.right);
        }
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(1);
        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        node3.left = node5;
        new Solution().pruneTree(node1);
    }
    // 第一种写法，不优雅
//    public boolean process(TreeNode root) {
//        // 如果左子树可以移除，右子树也可以移除，并且本树.val == 0 就可以移除
//        // 如果左子树或右子树中有一个不能移除，那本树就不能移除
//        if (root.left == null && root.right == null) {
//            return root.val == 0;
//        }
//        // 如果有左子树，去判断左子树是否可以移除
//        boolean removeLeft = true;
//        boolean removeRight = true;
//        if (root.left != null) {
//            removeLeft = process(root.left);
//        }
//        if (root.right != null) {
//            removeRight = process(root.right);
//        }
//
//        if (removeLeft) root.left = null;
//        if (removeRight) root.right = null;
//        if (removeLeft && removeRight) {
//            return root.val == 0;
//        } else {
//            return false;
//        }
//    }
}