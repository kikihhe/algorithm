package 重排链表;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public static void main(String[] args) {
        ListNode head1 = new ListNode();
        ListNode head2 = new ListNode();
        ListNode head3 = new ListNode();
        ListNode head4 = new ListNode();
        head1.val = 1;
        head2.val = 2;
        head3.val = 3;
        head4.val = 4;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        Solution solution = new Solution();
        solution.reorderList(head1);

    }
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return ;
        // 找到中间节点
        ListNode mid = find(head);
        // 断开head与mid的联系
        ListNode list1 = head;
        ListNode list2 = mid.next;
        mid.next = null;



        // 将中间节点之后的节点翻转
        list2 = reverse(list2);


        // 合并链表
        merge(list1, list2);




    }
    private ListNode find(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    private void merge(ListNode list1, ListNode list2) {
        ListNode temp1;
        ListNode temp2;
        while (list1 != null && list2 != null) {
            temp1 = list1.next;
            temp2 = list2.next;
            
            list1.next = list2;
            list1 = temp1;

            list2.next = list1;
            list2 = temp2;
            
        }
    }
}