package com.xiaohe.树.翻转二叉树;


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
     * 解题思路 :
     * 1. 交换当前root的左右子节点
     * 2. 递归左子节点
     * 3. 递归右子节点
     * 4. 返回root
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        swap(root);
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
    private void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}