package 题目.第七题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public static List<List<Integer>> levelOrder(TreeNode root){
        // 存结果
        List<List<Integer>> resLists = new ArrayList<>();
        // 结点暂存队列中
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return null;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            // 临时结果集
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int i = 0; i <queueSize ; i++) {
            	// 取出队头元素，并且放入临时结果集中
                TreeNode treeNode = queue.poll();
                temp.add(treeNode.val);
                // 将左子树入队
                if (treeNode.left!=null){
                    queue.add(treeNode.left);
                }
                // 将右子树入队
                if (treeNode.right!=null){
                    queue.add(treeNode.right);
                }
            }
            // 将每层遍历的结果存入结果集
            resLists.add(temp);
        }
        return resLists;
    }
}


class TreeNode {
    int val; //结点值
    TreeNode left; //左子树结点
    TreeNode right; //右子树结点

    public TreeNode(int val) {
        this.val = val;
    }
}
