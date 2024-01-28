package com.xiaohe.链表.反转链表;


// Definition for singly-linked list.
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

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        // 拿到链表的尾节点
        ListNode node = reverseList(head.next);
        // 当前节点的下一个节点指向自己
        head.next.next = head;
        // 当前节点的next置空
        head.next = null;
        return node;
    }
}