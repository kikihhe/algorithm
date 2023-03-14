package 单子;

public class Tree {
	
	TreeNode root;
	
	public Tree() {
		root = null;
	}
	
	public void makeRoot(String d) {
		root = new TreeNode(d);
	}
	
	public TreeNode getRoot() {
		return root;
	}
	
	
}
