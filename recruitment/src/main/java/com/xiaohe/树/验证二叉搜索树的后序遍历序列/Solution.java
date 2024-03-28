package com.xiaohe.树.验证二叉搜索树的后序遍历序列;

/**
 * LCR 152. 验证二叉搜索树的后序遍历序列
 * 请实现一个函数来判断整数数组 postorder 是否为二叉搜索树的后序遍历结果。
 */
class Solution {
    /**
     * 解题思路 :
     * 二叉搜索树的性质 : root的左子树都小于 root，root的右子树都大于root
     * 二叉搜索树的后序遍历的性质 : 最后一个值为root，左子树在前面，右子树在后面。
     * 只需要在后序遍历中找到左子树与右子树的边界，判断所有左子树是否小于root、所有右子树是否大于root，并且递归判断左子树和右子树即可。
     */
    public boolean verifyTreeOrder(int[] arr) {
        if (arr == null || arr.length == 1) {
            return true;
        }
        return process(arr, 0, arr.length - 1);
    }

    // 判断 arr[left, right] 是否为二叉搜索树
    public boolean process(int[] arr, int left, int right) {
        if (left >= right) {
            return true;
        }
        // 最右边的为这颗树的根节点
        // 找到第一个大于根节点的树的位置
        // 4,9,6,5,8
        // i = 1
        int root = arr[right];
        int i = left;
        while (arr[i] < root) {
            i++;
        }
        // 如果 arr[i + 1, right -1] 之间有小于 root 的，返回 false
        for (int k = i + 1; k < right; k++) {
            if (arr[k] < root) return false;
        }
        // 递归左子树和右子树
        return process(arr, left, i - 1) && process(arr, i, right - 1);
    }
}