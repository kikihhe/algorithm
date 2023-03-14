package 单子;

public class TreeNode {
	
	TreeNode left;
	TreeNode right;
	String data;
	
	public TreeNode(String dat) {
		data = dat;
	}
	
	public void setLeft(TreeNode l) {
		left = l;
	}
	
	public void setRight(TreeNode r) {
		right = r;
	}
	
	public TreeNode getRight() {
		return right;
	}
	
	public TreeNode getLeft() {
		return left;
	}
	
	public String getData() {
		return data;
	}

}
