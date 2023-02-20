package 两数相加;

import java.util.ArrayList;
import java.util.List;

/**

 */
public class ListNode {
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
class Solution {
    /**
     * l1是第一个链表的头节点
     * l2是第二个链表的头节点
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int t = 0;
        int i = 0;

        while (l1 != null && l2 != null) {
            int a = l1.val;
            int b = l2.val;
            i = (a + b + t) % 10;
            cur.next = new ListNode(i);
            t = (a + b + t) / 10;
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        // l2结束，但l1未结束
        while (l1 != null) {
            cur.next = new ListNode((l1.val + t) % 10);
            t = (l1.val + t) / 10;
            cur = cur.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            cur.next = new ListNode((l2.val + t) % 10);
            t = (l2.val + t) / 10;
            cur = cur.next;
            l2 = l2.next;
        }

        if (t != 0) {
            cur.next = new ListNode(t);
        }


        return head.next;



    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode a = new ListNode(9);
        ListNode b = new ListNode(9);
        ListNode c = new ListNode(9);
        ListNode d = new ListNode(9);
        ListNode e = new ListNode(9);
        ListNode f = new ListNode(9);
        ListNode g = new ListNode(9);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
//        ListNode c = new ListNode();
        ListNode h = new ListNode(9);
        ListNode i = new ListNode(9);
        ListNode j = new ListNode(9);
        ListNode k = new ListNode(9);
        h.next = i;
        i.next = j;
        j.next = k;



        ListNode listNode = solution.addTwoNumbers(a, d);
        while(listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}