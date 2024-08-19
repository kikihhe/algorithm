package com.xiaohe.树.二叉树的最近公共祖先;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


class Solution {
    /**
     * 使用递归去左子树与右子树中寻找这两个目标节点，递归的返回值：left、right。递归的终止条件：
     * 1. 当前节点为空
     * 2. 当前节点等于 p 或 q
     *
     * 根据递归的返回值，可展开为以下情况：
     * 1. left 和 right 同时为空，说明整棵树中没有 p 和 q 这两个节点
     * 2. left 和 right 同时非空，说明 p 和 q 在root 的异侧（分别在左右子树中），那么直接返回 root
     * 3. left 为空，right 非空，说明 p 和 q 都在右子树中，返回 right
     * 4. left 非空，right 为空，说明 p 和 q 都在左子树中，返回 left
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果当前节点是p或q直接返回
        if (root == null || root == p || root == q) {
            return root;
        } 
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}