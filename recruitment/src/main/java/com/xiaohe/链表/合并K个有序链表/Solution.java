package com.xiaohe.链表.合并K个有序链表;

import java.util.Comparator;
import java.util.PriorityQueue;

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
 * 解题原理:
 * 1. 将链表数组中的节点放入小根堆中
 * 2. 从小根堆中取出最小节点，将此节点的next节点放入小根堆
 * 3. 将取出的节点拼到虚拟链表后
 * 循环一直到小根堆中没有数据即可
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < lists.length; i++) {
            queue.offer(lists[i]);
        }
        ListNode newHead = new ListNode();
        ListNode p = newHead;
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            if (poll.next != null) {
                queue.offer(poll.next);
            }
            p.next = poll;
            p = poll;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;

        ListNode c1 = new ListNode(2);
        ListNode c2 = new ListNode(6);
        c1.next = c2;

        ListNode[] lists = new ListNode[3];
        lists[0] = a1;
        lists[1] = b1;
        lists[2] = c1;
        ListNode temp = new Solution().mergeKLists(lists);
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }


    }
}