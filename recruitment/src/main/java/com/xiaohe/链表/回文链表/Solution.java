package com.xiaohe.链表.回文链表;


/**
 * 判断给定的链表是否为回文链表
 * 进阶：空间复杂度O(1)，时间复杂度O(n)
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    /**
     * 可以反转整个链表，但是由于要记录反转前的链表状态，所以空间复杂度为 O(n)
     * 那么我们只反转后半部分的链表即可
     * 1. 通过快慢指针找到中间节点
     * 2. 反转后半部分的链表
     * 3. 比较前半部分与后半部分
     */
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // slow是第一部分的结尾，slow.next 是第二部分的开始
        ListNode two = reverse(slow.next);
        slow.next = null;
        while (head != null && two != null) {
            if (head.val != two.val) {
                return false;
            }
            head = head.next;
            two = two.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return tail;
    }
}