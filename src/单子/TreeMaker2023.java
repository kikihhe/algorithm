package 单子;

import java.util.Random;

public class TreeMaker2023 {
    public TreeMaker2023() {
    }

    public static void main(String[] args) {
        for(int i = 1; i < 13; ++i) {
            Tree t = getTree(i);
            System.out.println();
        }

    }

    public static Tree getTree(int num) {
        return makeTree(num);
    }

    private static double getGaussian(double min, double max) {
        Random rng = new Random();
        double value = rng.nextGaussian() / 2.0D;
        double mid = (max + min) / 2.0D;
        double newValue = value + mid;
        if (newValue > max) {
            newValue = max;
        }

        if (newValue < min) {
            newValue = min;
        }

        return newValue;
    }

    private static Tree makeTree(int num) {
        Tree tree = new Tree();
        String message = "";
        if (num == 0) {
            message = "Don't tell anyone what the secret messages say!";
        }

        if (num == 1) {
            message = "Why do you think Aaron is always so happy?";
        }

        if (num == 2) {
            message = "Did you know that Isabella likes to dance?";
        }

        if (num == 3) {
            message = "Have you ever noticed how much time Junhao spends playing on his computer?";
        }

        if (num == 4) {
            message = "I have a dream.... Brook will arrive 15 minutes early to class.";
        }

        if (num == 5) {
            message = "Why does Justin always wear shorts, even when it's freezing outside?";
        }

        if (num == 6) {
            message = "The bravest student in our class is Marco. He's the only one to sit in the front row.";
        }

        if (num == 7) {
            message = "I think Luke should get a few more hours of sleep.";
        }

        if (num == 8) {
            message = "I think Jeremy is smart because he listens a lot. Be more like Jeremy.";
        }

        if (num == 9) {
            message = "Why do you think Ryan didn't want to do Hire a Senior? Was he afraid?";
        }

        if (message.length() == 0) {
            return null;
        } else {
            int splitPoint = (int)((double)message.split(" ").length * getGaussian(0.0D, 1.0D));
            String[] words = message.split(" ");
            String leftWord = "";
            String rightWord = "";

            int i;
            for(i = 0; i < splitPoint; ++i) {
                leftWord = String.valueOf(leftWord) + words[i] + " ";
            }

            for(i = splitPoint; i < words.length; ++i) {
                rightWord = String.valueOf(rightWord) + words[i] + " ";
            }

            tree.makeRoot("");
            tree.getRoot().setLeft(makeNodeTree(leftWord.trim()));
            tree.getRoot().setRight(makeNodeTree(rightWord.trim()));
            return tree;
        }
    }

    private static TreeNode makeNodeTree(String message) {
        if (message.length() == 0) {
            return null;
        } else {
            TreeNode newNode;
            if (message.split(" ").length == 1) {
                newNode = new TreeNode(message);
                return newNode;
            } else {
                newNode = new TreeNode("");
                int splitPoint = (int)((double)message.split(" ").length * getGaussian(0.0D, 1.0D));
                String[] words = message.split(" ");
                String leftWord = "";
                String rightWord = "";

                int i;
                for(i = 0; i < splitPoint; ++i) {
                    leftWord = String.valueOf(leftWord) + words[i] + " ";
                }

                for(i = splitPoint; i < words.length; ++i) {
                    rightWord = String.valueOf(rightWord) + words[i] + " ";
                }

                newNode.setLeft(makeNodeTree(leftWord.trim()));
                newNode.setRight(makeNodeTree(rightWord.trim()));
                return newNode;
            }
        }
    }

    private static Tree treeOne() {
        Tree tr = new Tree();
        tr.makeRoot("");
        tr.getRoot().setLeft(new TreeNode(""));
        tr.getRoot().setRight(new TreeNode(""));
        tr.getRoot().getLeft().setLeft(new TreeNode(""));
        tr.getRoot().getLeft().setRight(new TreeNode(""));
        tr.getRoot().getRight().setLeft(new TreeNode(""));
        tr.getRoot().getRight().setRight(new TreeNode(""));
        tr.getRoot().getLeft().getLeft().setLeft(new TreeNode("Don't"));
        tr.getRoot().getLeft().getLeft().setRight(new TreeNode("tell"));
        tr.getRoot().getLeft().getRight().setLeft(new TreeNode("everyone"));
        tr.getRoot().getLeft().getRight().setRight(new TreeNode("what"));
        tr.getRoot().getRight().getLeft().setLeft(new TreeNode("the"));
        tr.getRoot().getRight().getLeft().setRight(new TreeNode("secret"));
        tr.getRoot().getRight().getRight().setLeft(new TreeNode("messages"));
        tr.getRoot().getRight().getRight().setRight(new TreeNode("are!"));
        return tr;
    }

    private static Tree treeTwo() {
        Tree tr = new Tree();
        tr.makeRoot("");
        tr.getRoot().setLeft(new TreeNode(""));
        tr.getRoot().setRight(new TreeNode(""));
        tr.getRoot().getLeft().setLeft(new TreeNode(""));
        tr.getRoot().getLeft().setRight(new TreeNode(""));
        tr.getRoot().getRight().setLeft(new TreeNode(""));
        tr.getRoot().getRight().setRight(new TreeNode(""));
        tr.getRoot().getLeft().getLeft().setLeft(new TreeNode("Raise"));
        tr.getRoot().getLeft().getLeft().setRight(new TreeNode("your"));
        tr.getRoot().getLeft().getRight().setLeft(new TreeNode(""));
        tr.getRoot().getLeft().getRight().setRight(new TreeNode("you"));
        tr.getRoot().getRight().getLeft().setLeft(new TreeNode("think"));
        tr.getRoot().getRight().getLeft().setRight(new TreeNode("Xander"));
        tr.getRoot().getRight().getRight().setLeft(new TreeNode("is"));
        tr.getRoot().getRight().getRight().setRight(new TreeNode("handsome."));
        tr.getRoot().getLeft().getRight().getLeft().setLeft(new TreeNode("hand"));
        tr.getRoot().getLeft().getRight().getLeft().setRight(new TreeNode("if"));
        return tr;
    }

    private static Tree treeThree() {
        Tree tr = new Tree();
        tr.makeRoot("");
        tr.getRoot().setLeft(new TreeNode(""));
        tr.getRoot().setRight(new TreeNode(""));
        tr.getRoot().getLeft().setLeft(new TreeNode(""));
        tr.getRoot().getLeft().setRight(new TreeNode(""));
        tr.getRoot().getRight().setLeft(new TreeNode(""));
        tr.getRoot().getRight().setRight(new TreeNode(""));
        tr.getRoot().getLeft().getLeft().setLeft(new TreeNode("You"));
        tr.getRoot().getLeft().getLeft().setRight(new TreeNode("know"));
        tr.getRoot().getLeft().getRight().setLeft(new TreeNode(""));
        tr.getRoot().getLeft().getRight().setRight(new TreeNode("pretty"));
        tr.getRoot().getRight().getLeft().setLeft(new TreeNode("brilliant?"));
        tr.getRoot().getRight().getLeft().setRight(new TreeNode(""));
        tr.getRoot().getRight().getRight().setLeft(new TreeNode(""));
        tr.getRoot().getRight().getRight().setRight(new TreeNode("brilliant."));
        tr.getRoot().getLeft().getRight().getLeft().setLeft(new TreeNode("who"));
        tr.getRoot().getLeft().getRight().getLeft().setRight(new TreeNode("is"));
        tr.getRoot().getRight().getLeft().getRight().setLeft(new TreeNode("Cynthia"));
        tr.getRoot().getRight().getLeft().getRight().setRight(new TreeNode("Tang"));
        tr.getRoot().getRight().getRight().getLeft().setLeft(new TreeNode("is"));
        tr.getRoot().getRight().getRight().getLeft().setRight(new TreeNode("pretty"));
        return tr;
    }

    private static Tree treeFour() {
        Tree tr = new Tree();
        tr.makeRoot("");
        tr.getRoot().setLeft(new TreeNode(""));
        tr.getRoot().setRight(new TreeNode(""));
        tr.getRoot().getLeft().setLeft(new TreeNode(""));
        tr.getRoot().getLeft().setRight(new TreeNode(""));
        tr.getRoot().getRight().setLeft(new TreeNode(""));
        tr.getRoot().getRight().setRight(new TreeNode(""));
        tr.getRoot().getLeft().getLeft().setLeft(new TreeNode("Stop"));
        tr.getRoot().getLeft().getLeft().setRight(new TreeNode(""));
        tr.getRoot().getLeft().getRight().setLeft(new TreeNode(""));
        tr.getRoot().getLeft().getRight().setRight(new TreeNode("you"));
        tr.getRoot().getRight().getLeft().setLeft(new TreeNode("can"));
        tr.getRoot().getRight().getLeft().setRight(new TreeNode(""));
        tr.getRoot().getRight().getRight().setLeft(new TreeNode(""));
        tr.getRoot().getRight().getRight().setRight(new TreeNode("Jeffrey."));
        tr.getRoot().getLeft().getLeft().getRight().setLeft(new TreeNode("trying."));
        tr.getRoot().getLeft().getLeft().getRight().setRight(new TreeNode("There's"));
        tr.getRoot().getLeft().getRight().getLeft().setLeft(new TreeNode("no"));
        tr.getRoot().getLeft().getRight().getLeft().setRight(new TreeNode("way"));
        tr.getRoot().getRight().getLeft().getRight().setLeft(new TreeNode("be"));
        tr.getRoot().getRight().getLeft().getRight().setRight(new TreeNode("as"));
        tr.getRoot().getRight().getRight().getLeft().setLeft(new TreeNode("cool"));
        tr.getRoot().getRight().getRight().getLeft().setRight(new TreeNode("as"));
        return tr;
    }

    private static Tree treeFive() {
        Tree tr = new Tree();
        tr.makeRoot("");
        tr.getRoot().setLeft(new TreeNode(""));
        tr.getRoot().setRight(new TreeNode(""));
        tr.getRoot().getLeft().setLeft(new TreeNode(""));
        tr.getRoot().getLeft().setRight(new TreeNode(""));
        tr.getRoot().getRight().setLeft(new TreeNode(""));
        tr.getRoot().getLeft().getLeft().setLeft(new TreeNode("Don't"));
        tr.getRoot().getLeft().getLeft().setRight(new TreeNode("ask"));
        tr.getRoot().getLeft().getRight().setLeft(new TreeNode("Steven"));
        tr.getRoot().getLeft().getRight().setRight(new TreeNode("what"));
        tr.getRoot().getRight().getLeft().setLeft(new TreeNode("BS"));
        tr.getRoot().getRight().getLeft().setRight(new TreeNode("means."));
        return tr;
    }

    private static Tree treeSix() {
        Tree tr = new Tree();
        tr.makeRoot("");
        tr.getRoot().setLeft(new TreeNode(""));
        tr.getRoot().setRight(new TreeNode(""));
        tr.getRoot().getLeft().setLeft(new TreeNode(""));
        tr.getRoot().getLeft().setRight(new TreeNode("excited"));
        tr.getRoot().getRight().setLeft(new TreeNode("face!\""));
        tr.getRoot().getRight().setRight(new TreeNode(""));
        tr.getRoot().getLeft().getLeft().setLeft(new TreeNode("\"This"));
        tr.getRoot().getLeft().getLeft().setRight(new TreeNode(""));
        tr.getRoot().getRight().getRight().setLeft(new TreeNode("-Hao"));
        tr.getRoot().getRight().getRight().setRight(new TreeNode(""));
        tr.getRoot().getLeft().getLeft().getRight().setLeft(new TreeNode("is"));
        tr.getRoot().getLeft().getLeft().getRight().setRight(new TreeNode("my"));
        tr.getRoot().getRight().getRight().getRight().setRight(new TreeNode("Jin"));
        return tr;
    }
}