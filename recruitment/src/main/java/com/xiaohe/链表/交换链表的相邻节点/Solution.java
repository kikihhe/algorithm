package com.xiaohe.链表.交换链表的相邻节点;

/**
 * @author : 小何
 * @Description :
 * @date : 2024-01-28 15:27
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
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 无条件相信 swapPairs 方法可以将后续节点两两交换
        // 返回的 node 是两两交换后的 head.next.next 节点
        ListNode node = swapPairs(head.next.next);

        //  使用 newHead 记录 head.next，等会就要返回它
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = node;
        return newHead;
    }
}
