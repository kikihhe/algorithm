package com;
import java.util.Scanner;


class Node {
    int val;
    Node next;
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }

    private static Node sort(Node root) {
        if (root == null || root.next == null) {
            return null;
        }
        Node slow = findMid(root);
        Node p = slow.next;
        slow.next = null;
        Node newHed = sort(root);
        Node node = sort(p);
        Node process = process(root, p);
        Node q = process;
        while (q.next != null) {
            q = q.next;
        }
        q.next = node;
        return newHed;
    }


    private static Node findMid(Node root) {
        Node fast = root;
        Node slow = root;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private static Node process(Node root, Node p) {
        Node q = new Node();
        Node newHead = q;
        Node l1 = root;
        Node l2 = p;
        while (l1.next != null && l2.next != null) {
            if (l1.val < l2.val) {
                newHead.next = l1;
                l1 = l1.next;
                newHead = newHead.next;
            } else {
                newHead.next = l2;
                l2 = l2.next;
                newHead = newHead.next;

            }
        }
        if (l1.next != null) {
            newHead.next = l1.next;
        } else if (l2.next != null) {
            newHead.next = l2.next;
        }
        return q.next;
    }

}
