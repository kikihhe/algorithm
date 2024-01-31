package com.xiaohe.树.二叉树的所有路径;

import java.util.ArrayList;
import java.util.List;


// Definition for a binary tree node.
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
    private List<String> list = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        process(root, "");
        return list;
    }

    private void process(TreeNode root, String path) {
        String now = path + root.val;
        if (root.left == null && root.right == null) {
            list.add(now);
        }
        now = now + "->";
        if (root.left != null) {
            process(root.left, now);
        }
        if (root.right != null) {
            process(root.right, now);
        }
    }
}