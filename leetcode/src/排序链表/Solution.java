package 排序链表;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-03-10 21:13
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode p = head;
        while(p != null) {
            list.add(p);
            p = p.next;
        }
        list.sort((a, b) -> {
            return a.val - b.val;
        });
        p = list.get(0);
        head = p;
        for (int i = 1; i < list.size(); i++) {
            p.next = list.get(i);
            p = p.next;
        }
        return head;

    }
}
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
