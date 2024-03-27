package com.xiaohe.链表.重排练表;
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

class Solution {
    public static void main(String[] args) {
        ListNode n6 = new ListNode(6, null);
        ListNode n5 = new ListNode(5, n6);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        new Solution().reorderList(n1);

        ListNode p = n1;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
    public void reorderList(ListNode head) {
        if (head.next == null || head.next.next == null) return;

        // 快慢节点找到中间节点, 找到后，slow.next 为新链表的头节点, 将 slow 与后面的链表断开
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode list2 = slow.next;
        slow.next = null;

        // 将 list2 这条链表反转
        list2 = reverse(list2);

        // 设置虚拟头节点，将两个链表 head、list2 的节点放到虚拟头节点后面
        ListNode p1 = head;
        ListNode p2 = list2;

        ListNode v = new ListNode(-1, null);
        ListNode p3 = v;
        while (p1 != null && p2 != null) {
            p3.next = p1;
            p1 = p1.next;
            p3 = p3.next;

            p3.next = p2;
            p2 = p2.next;
            p3 = p3.next;
        }
        if (p1 != null) {
            p3.next = p1;
        }
        head = v.next;


    }

    public ListNode reverse(ListNode root) {
        if (root == null || root.next == null) {
            return root;
        }
        // 拿到最后一个节点，当作头节点
        ListNode newHead = reverse(root.next);
        root.next.next = root;
        root.next = null;

        return newHead;
    }
}