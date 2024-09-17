package com.xiaohe.链表.K个一组反转链表;



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    /**
     * 1. 虚拟头节点指向head
     * 2. start 和 end 是此次需要反转的链表的头节点、尾节点
     * 3. prev 是 start 前一个，nextGroup 是 end 后一个
     * 3. 反转 start - end
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;

        while (true) {
            ListNode start = dummy.next;
            ListNode end = start;
            // 找到这一组的尾节点
            for (int i = 0; i < k - 1 && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode nextGroup = end.next;
            end.next = null;
            // 开始翻转这一组
            ListNode newHead = reverseList(start);

            prev.next = newHead;
            start.next = nextGroup;

            prev = start;

        }
        return dummy.next;
    }

    private ListNode reverseList(ListNode root) {
        if (root == null || root.next == null) {
            return root;
        }
        ListNode newHead = reverseList(root.next);
        root.next.next = root;
        root.next = null;
        return newHead;
    }
}