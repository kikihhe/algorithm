package com.xiaohe.链表.反转链表Ⅱ;



//  Definition for singly-linked list.
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 给链表在前后装两个无用节点, 并且找到将要反转的节点以及节点的前后节点
        ListNode newHead = new ListNode(0, head);
        ListNode newTail = new ListNode(0);
        ListNode p = head;
        while (p != null && p.next != null) {
            p = p.next;
        }
        p.next = newTail;
        int count = 0;
        p = newHead;
        // 找到left的前一个节点
        ListNode a = findNode(left - 1, newHead);
        ListNode a1 = a.next;
        // 找到right节点
        ListNode b1 = findNode(right, newHead);
        ListNode b = b1.next;
        b1.next = null;
        p = reverseList(a1);
        a.next = p;
        while (p != null && p.next != null) {
            p = p.next;
        }
        p.next = b;
        // 断开最后一个节点
        while (p != null && p.next != null && p.next.next != null) {
            p = p.next;
        }
        p.next = null;
        return newHead.next;

    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode listNode = new Solution().reverseBetween(node1, 2, 5);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 拿到头节点
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
    private ListNode findNode(int index, ListNode head) {
        ListNode p = head;
        int count = 0;
        while (count < index) {
            p = p.next;
            count++;
        }
        return p;
    }
}