package 构建搜索二叉树;

import java.util.*;
class BinaryTree {
    private static class Node {
        public int data;
        public Node left;
        public Node right;
        public Node(int data) {
            this.data =- data;
        }
    }

    public Node root;
    public int size;
    public void add(int data) {
        size++;
        this.root = add(root, data);
    }
    public Node add(Node node, int data) {
        if(node == null) {
            node = new Node(data);
            return node;
        } else if (data > node.data) {
            node.left = add(node.left, data);
        } else if (data < node.data) {
            node.right = add(node.right, data);
        }
        return node;
    }
    public boolean isCompleteTree(Node node) {
        if (node == null) return true;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            // 将一个节点出队
            Node p = queue.poll();
            // 如果节点不为空，将它的左右孩子进入队列
            if (p != null) {
                queue.offer(p.left);
                queue.offer(p.right);
            } else {
                // 如果节点为空，看看还有没有后续节点
                while(!queue.isEmpty()) {
                    Node poll = queue.poll();
                    if (poll != null) return false;
                }
            }
        }
        return true;
    }
    public List<List<Integer>> levelOrder(Node node) {
        List<List<Integer>> result = new ArrayList<>();
        if (node == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                Node poll = queue.poll();
                list.add(poll.data);
                if (poll.left != null) queue.offer(poll.left);
                if(poll.right != null) queue.offer(poll.right);
                size --;
            }
            result.add(list);
        }
        return result;
    }
}



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        BinaryTree binaryTree = new BinaryTree();
        // 输入值，构建搜索二叉树
        for (int i = 0; i < N; i++) {
            binaryTree.add(scanner.nextInt());
        }
        // 查看搜索二叉树是否为完全二叉树
        boolean completeTree = binaryTree.isCompleteTree(binaryTree.root);

    }
}