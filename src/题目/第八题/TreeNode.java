package 题目.第八题;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) {
        val = x;
    }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class InvertBinaryTree {
//递归的先序遍历实现
    public static void pre(TreeNode root) {
        if (root == null) {
            return ;
        }
        System.out.println(root.val);
        pre(root.left);
        pre(root.right);
    }
    public static TreeNode invertTree(TreeNode root) {
        // 如果该节点不为空，可以查看它的左右子树
        if (root != null) {
            // t为暂时节点，辅助完成旋转
            TreeNode t = root.left;
            root.left = root.right;
            root.right = t;
            // 该节点的左右节点旋转完之后，旋转该节点的左右子树
            invertTree(root.left);
            invertTree(root.right);
            return root;
        } else {
            // 如果这个节点为空，那它也该以null的形式挂在它的父节点身上
            return null;
        }
    }

    public static void main(String[] args) {
        // 构建一个树，如下:
        /**
         *            1
         *         2      3
         *      4    5  6   7
         * 反转后的树长这样子：
         *            1
         *        3       2
         *      7   6   5    4
         * 先序遍历的结果应该为: 1 3 7 6 2 5 4
         * 查看反转后怎么样
         */

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        TreeNode treeNode = invertTree(node1);
        pre(treeNode);



    }


}