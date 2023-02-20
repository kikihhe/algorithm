package trimtree;

class Trie {
    public static class Node {
        public Node[] nexts = new Node[58];
        // end代表以此节点为尾节点的字符串数量。
        int end;
    }
    public Node root;
    private Node node; // 用于指向头节点遍历的傀儡节点

    public Trie() {
        root = new Node();
    }

    /**
     * 向前缀树中插入一个字符串
     * @param word
     */
    public void insert(String word) {
        node = root;
        char[] arr = word.toCharArray();
        int index = 0;
        for (int i = 0; i < arr.length; i ++) {
            index = arr[i] - 'A';
            if (node.nexts[index] == null) {
                node.nexts[index] = new Node();
            }
            node = node.nexts[index];
        }
        node.end ++;
    }

    /**
     * 查找字符串是否在前缀树中出现过
     * @param word
     * @return
     */
    public boolean search(String word) {
        node = root;
        char[] arr = word.toCharArray();
        int index = 0;
        for (int i = 0; i < arr.length; i ++) {
            index = arr[i] - 'A';
            if (node.nexts[index] == null) {
                return false;
            }
            node = node.nexts[index];
        }
        if (node.end != 0)return true;
        else return false;
        
    }

    /**
     * 检查前缀树中有无以prefix开头的字符串
     * @param prefix
     * @return
     */
    public boolean startsWith(String prefix) {
        node = root;
        char[] arr = prefix.toCharArray();
        int index = 0;
        for (int i = 0; i < arr.length; i ++) {
            index = arr[i] - 'A';
            if (node.nexts[index] == null) {
                return false;
            }
            node = node.nexts[index];
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(Math.round(3.5));
    }
}
