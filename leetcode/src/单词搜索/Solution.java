package 单词搜索;

class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int[][] mark = new int[board.length][board[0].length];
                if (dfs(board, mark, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }
    // board: 题目所给数组
    // mark: 记录已经使用过的位置
    // word: 所求字符串
    // x: 当前纵坐标
    // y: 当前横坐标
    // index: 当前所到达的位置是字符串的下标
    private boolean dfs(char[][] board, int[][] mark, String word, int x, int y, int index) {
        // 判断越界条件
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
        // 如果已经走过这个位置
        if(mark[x][y] == 1) return false;
        // 如果这个位置和当前字符串的索引元素不同
        if (board[x][y] != word.charAt(index)) return false;
        if (index == word.length() - 1) return true;

        // 将此处标记已经走过
        mark[x][y] = 1;
        // 开始遍历. 有四个方向，上下左右
//        return      dfs(board, mark, word, x - 1, y, index + 1) // 上
//                ||  dfs(board, mark, word, x + 1, y, index + 1) // 下
//                ||  dfs(board, mark, word, x, y + 1, index + 1) // 右
//                ||  dfs(board, mark, word, x, y - 1, index + 1); // 左
        boolean a = dfs(board, mark, word, x - 1, y, index + 1);
        boolean b = dfs(board, mark, word, x + 1, y, index + 1);
        boolean c = dfs(board, mark, word, x, y + 1, index + 1);
        boolean d = dfs(board, mark, word, x, y - 1, index + 1);
        mark[x][y] = 0;
        return a || b || c || d;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] a = {
                "ABCE",
                "SFES",
                "ADEE"
        };
        String word = "ABCESEEEFS";
        char[][] board = new char[3][4];
        for (int i = 0; i < board.length; i++) {
                board[i] = a[i].toCharArray();
        }
        boolean exist = s.exist(board, word);
        System.out.println(exist);
    }


}