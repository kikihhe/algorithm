package com.xiaohe.树.二叉树展开为链表;


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

/**
 * 1. 当前节点是否有左孩子，如果有左孩子就需要进行操作。如果没有左孩子，当前节点移动到右孩子上继续判断
 * 2. 拿到当前节点的左孩子后，需要将左孩子这一整棵树移动到当前节点的右孩子那里。所以需要拿到左孩子的最右孩子
 */
public class Solution {
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode temp = root.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                // 现在temp为左子树的最右节点
                // 将 root 的右子树挂在temp的右子树上
                temp.right = root.right;
                // 将 temp 从root的左子树变成root的右子树
                root.right = root.left;
                // root 的左子树置为空
                root.left = null;
            }
            root = root.right;
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        new Solution().flatten(root);
    }
}