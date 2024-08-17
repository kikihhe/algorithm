package com.xiaohe.链表.旋转链表;

/**
 * 给你一个链表的头节点 `head` ，旋转链表，将链表每个节点向右移动 `k` 个位置。
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * 1. 获取链表长度，在获取长度的最后将链表成环
 * 2. 计算新指针要走多少步
 * 3. 新指针走到相应位置后，断开与新head的连接，返回新head
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        ListNode p = head;
        // 计算链表长度
        int count = 1;
        while (p.next != null) {
            p = p.next;
            count++;
        }
        // 把链表头尾串起来
        p.next = head;
        k = k % count;
        ListNode a = head;
        for (int i = 0; i < count - k - 1; i++) {
            a = a.next;
        }
        ListNode ret = a.next;
        a.next = null;
        return ret;

    }
}