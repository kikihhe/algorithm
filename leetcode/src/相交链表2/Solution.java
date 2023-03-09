package 相交链表2;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == headB) return headA;
        ListNode A = headA;
        ListNode B = headB;

        while(A != B) {
            if(A.next == null && B.next == null && A != B) return null;

            A = (A.next == null) ? headB : A.next;
            B = (B.next == null) ? headA : B.next;
        }
        return (A == B) ? A : null;
        
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode headA = new ListNode(3);
        ListNode headB = new ListNode(2);
        headB.next = headA;
        ListNode intersectionNode = s.getIntersectionNode(headA, headB);
        System.out.println(intersectionNode.val);
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}