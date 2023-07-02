package 树的子结构;

class Solution {
    public boolean isSubStructure(TreeNode a, TreeNode b) {
        if (b == null || a == null) return false;
        return equals(a,b) || isSubStructure(a.left, b) || isSubStructure(a.right, b);

    }
    public boolean equals(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null || a.val != b.val) {
            return false;
        }
        return equals(a.left, b.left) && equals(a.right, b.right);

    }

}