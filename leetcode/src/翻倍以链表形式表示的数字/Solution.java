package 翻倍以链表形式表示的数字;



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution {
    public ListNode doubleIt(ListNode head) {
        process(head);
        return head;
    }
    private int process(ListNode head) {
        if (head == null) {
            return 0;
        }
        int x = head.val;
        int t = process(head.next);
        head.val = (head.val * 2 + t) % 10;
        t = (x * 2 + t) / 10;
        return t;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(8);
        ListNode c = new ListNode(9);
        a.next = b;
        b.next = c;
        Solution solution = new Solution();
        ListNode listNode = solution.doubleIt(a);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}