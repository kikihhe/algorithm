package 单子83;

import java.util.Stack;

// Node class represents a node in a binary tree
class Node {
    private int number;
    private Node left;
    private Node right;

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}

// BSTNode class represents a binary search tree
class BSTNode {
    private Node root;

    public BSTNode() {
        System.out.println("Binary Search Tree");
    }

    // Method to add a node to the binary search tree
    public void addNode(Node newNode) {
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            while (true) {
                if (newNode.getNumber() < current.getNumber()) {
                    if (current.getLeft() == null) {
                        current.setLeft(newNode);
                        break;
                    } else {
                        current = current.getLeft();
                    }
                } else {
                    if (current.getRight() == null) {
                        current.setRight(newNode);
                        break;
                    } else {
                        current = current.getRight();
                    }
                }
            }
        }
    }

    // Method to remove a node from the binary search tree
    public void removeNode(int number) {
        Node current = root;
        Node parent = null;
        boolean isLeftChild = true;

        while (current.getNumber() != number) {
            parent = current;

            if (number < current.getNumber()) {
                current = current.getLeft();
                isLeftChild = true;
            } else {
                current = current.getRight();
                isLeftChild = false;
            }

            if (current == null) {
                System.out.println("No such node in the tree");
                return;
            }
        }


    }

    // Method to print all numbers stored in the nodes via pre-order traversal
    public void preOrderIterative() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.print(current.getNumber() + " ");

            if (current.getRight() != null) {
                stack.push(current.getRight());
            }
            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a binary search tree object
        BSTNode bst = new BSTNode();

        // Create Node objects with given integer numbers
        Node node70 = new Node();
        node70.setNumber(70);
        Node node31 = new Node();
        node31.setNumber(31);
        Node node93 = new Node();
        node93.setNumber(93);
        Node node14 = new Node();
        node14.setNumber(14);
        Node node73 = new Node();
        node73.setNumber(73);
        Node node94 = new Node();
        node94.setNumber(94);
        Node node7 = new Node();
        node7.setNumber(7);
        Node node23 = new Node();
        node23.setNumber(23);
        Node node67 = new Node();
        node67.setNumber(67);
        Node node99 = new Node();
        node99.setNumber(99);
        Node node25 = new Node();
        node25.setNumber(25);
        Node node43 = new Node();
        node43.setNumber(43);
        Node node56 = new Node();
        node56.setNumber(56);
        Node node88 = new Node();
        node88.setNumber(88);
        Node node77 = new Node();
        node77.setNumber(77);
        Node node95 = new Node();
        node95.setNumber(95);

        // Add the nodes to the binary search tree
        bst.addNode(node70);
        bst.addNode(node31);
        bst.addNode(node93);
        bst.addNode(node14);
        bst.addNode(node73);
        bst.addNode(node94);
        bst.addNode(node7);
        bst.addNode(node23);
        bst.addNode(node67);
        bst.addNode(node99);
        bst.addNode(node25);
        bst.addNode(node43);
        bst.addNode(node56);
        bst.addNode(node88);
        bst.addNode(node77);
        bst.addNode(node95);

        // Remove a node from the binary search tree
        bst.removeNode(88);

        // Print all numbers in the binary search tree via pre-order traversal
        bst.preOrderIterative();
    }
}
