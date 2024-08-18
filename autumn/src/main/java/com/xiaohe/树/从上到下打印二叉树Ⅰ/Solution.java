package com.xiaohe.树.从上到下打印二叉树Ⅰ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 递归写法
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
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
     * 递归方法:
     * 将一颗树以另外一种方式展示:
     *       1                      1
     *    2     3        ->         2   3
     * 4    5 6   7                 4   5   6   7
     * 这样就将整棵树以 田 字摆开，我们在向下递归是肯定是 1 -> 2 -> 4 -> 2 -> 5 -> 2 -> 1 -> 3....
     * 可以使用 index 代表当前节点所在层数，每下降一层根据情况 new 一个 List 存这一层的节点
     * 遍历到 4 时，根据 index 取出它应该在的 List，然后放进去，如果有子节点就去递归，没有就算了
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(1, root, result);
        return result;
    }

    /**
     *
     * @param index 当前节点所在深度
     * @param root 当前节点
     * @param result
     */
    private void dfs(int index, TreeNode root, List<List<Integer>> result) {
        // 假如现在的 result=[ [1], [2] ], 现在在第三层，那么就添一个List
        if (result.size() < index) {
            result.add(new ArrayList<>());
        }
        // 找到当前节点所在层的List
        List<Integer> list = result.get(index);
        list.add(root.val);
        // 递归处理左子树
        if (root.left != null) {
            dfs(index + 1, root.left, result);
        }
        if (root.right != null) {
            dfs(index + 1, root.right, result);
        }
    }
}