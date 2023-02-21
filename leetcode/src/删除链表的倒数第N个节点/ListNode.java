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
    // 前后指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 构造一个节点，指向头节点，防止要删除的节点是头节点的情况
        ListNode temp = new ListNode();
        temp.next = head;
        ListNode p1 = temp;
        ListNode p2 = temp;
        for (int i = 0; i < n; i++) {
            p2 = p2.next;
        }
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return temp.next;
    }
//    // 遍历...
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//
//        ListNode p = head;
//        int size = 0;
//        while (p != null) {
//            p = p.next;
//            size ++;
//        }
//        if (size == 1) return null;
//        if (n == size) return head.next;
//        size -= 1;
//        p = head;
//        while (size > n) {
//            p = p.next;
//            size -= 1;
//        }
//        p.next = p.next.next;
//        return head;
//
//    }
}
