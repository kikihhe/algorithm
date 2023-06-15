package 单子;

public class TreeSearch {
	public static void main(String[] args) {
		Tree t = TreeMaker2023.getTree(9);
		TreeNode root = t.getRoot();
		process(root);
//		t.getRoot();
//		System.out.println(t);
	}
	public static void process(TreeNode node){
		if (node == null) return;
		if (node.getLeft() == null && node.getRight() == null) {
			System.out.print(node.getData() + " ");
		}
		if (node.getLeft() != null) {
			process(node.getLeft());
		}
		if (node.getRight() != null) {
			process(node.getRight());
		}
	}
}