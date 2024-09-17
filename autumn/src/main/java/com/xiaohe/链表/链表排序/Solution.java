package com.xiaohe.链表.链表排序;


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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 拿到中间节点并截断
        ListNode slow = splitList(head);
        ListNode mid = slow.next;
        slow.next = null;
        // 排序前半段
        ListNode list1 = sortList(head);
        // 排序后半段
        ListNode list2 = sortList(mid);
        // 合并两个有序链表
        return mergeList(list1, list2);
    }

    private ListNode splitList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    private ListNode mergeList(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeList(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeList(list1, list2.next);
            return list2;
        }
    }
}