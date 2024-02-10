package com.xiaohe.队列.二叉树的中序遍历;


import java.util.*;


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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        TreeNode temp = root;
        // 先将树的最左侧节点全部入栈
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
        TreeNode cur = null;
        while (!stack.isEmpty() || cur != null) {
            cur = stack.pop();
            list.add(cur.val);
            if (cur.right != null) {
                TreeNode right = cur.right;
                while (right != null) {
                    stack.push(right);
                    right = right.left;
                }
            }
        }
        return list;
    }


    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node6 = new TreeNode(6);
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node8 = new TreeNode(8);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node5.left = node7;
//        node5.right = node8;
//        node3.right = node6;
//
//        System.out.println(new Solution().inorderTraversal(node1));
        Map<Integer, String> map = new HashMap<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
        }

        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            Integer key = entry.getKey();
            String value = entry.getValue();
        }

    }
}
