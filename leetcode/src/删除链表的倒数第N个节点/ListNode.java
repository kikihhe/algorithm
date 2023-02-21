package 删除链表的倒数第N个节点;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-02-21 20:14
 */

// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    // 遍历...
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode p = head;
        int size = 0;
        while (p != null) {
            p = p.next;
            size ++;
        }
        if (size == 1) return null;
        if (n == size) return head.next;
        size -= 1;
        p = head;
        while (size > n) {
            p = p.next;
            size -= 1;
        }
        p.next = p.next.next;
        return head;

    }
}
