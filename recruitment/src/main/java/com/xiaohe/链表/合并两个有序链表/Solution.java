package com.xiaohe.链表.合并两个有序链表;

/**
 * @author : 小何
 * @Description :
 * @date : 2024-01-28 14:20
 */

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 如果l1为空，说明l1这条链表连接到末尾了，返回l2
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 给定两个链表的头节点，将这两条链表分为两部分:
        // 较小的头节点、其他所有节点
        // 我们的目标是 较小的头节点指向后续的所有节点，最后返回这个头节点。
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}