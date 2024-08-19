package com.xiaohe.树.验证二叉搜索树;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 注意，是整颗子树的全部节点跟当前节点的关系，而不是子节点跟当前节点的关系。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
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
     * 遍历时可以携带最大值与最小值，当前节点遍历后肯定要遍历子节点
     * - 遍历左子树时，当前节点作为左子树的最大值
     * - 遍历右子树时，当前节点作为右子树的最小值
     * - 遍历当前节点时，value需要在最大值与最小值之间
     *
     * 对于整颗左子树，最小值无限制，使用 Long.MIN_VALUE 代替
     * 对于整颗右子树，最大值无限制，使用 Long.MAX_VALUE 代替
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}