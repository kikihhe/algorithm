


 class TreeNode {
  int val = 0;
  TreeNode left = null;
  TreeNode right = null;
  public TreeNode(int val) {
    this.val = val;
  }
}


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 输入一个二叉树，和两个int值，返回最底层公共父节对应的值。
     * @param root TreeNode类 二叉树的根节点
     * @param m int整型 第一个值
     * @param n int整型 第二个值
     * @return int整型
     */
    public int lowestCommonAncestor (TreeNode root, int m, int n) {
        // write code here
        TreeNode p1 = new TreeNode(m);
        TreeNode p2 = new TreeNode(n);
        TreeNode result = process(root, p1, p2);
        return result.val;
    }
    public TreeNode process(TreeNode head, TreeNode p1, TreeNode p2) {
        if (head == null) {
            return head;
        } 
        TreeNode t1 = process(head.left, p1, p2);
        TreeNode t2 = process(head.right, p1, p2);
        if (head.val == p1.val || head.val == p2.val)  {
            return head;
        }
        if (t1 != null && t2 != null) {
            return head;
        }
        return t1 == null ? t2 : t1;
    }

}