/**
  * 题目Id：剑指 Offer 05
  * 题目：替换空格
  * 日期：2023-04-15 11:21:39
*/
//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
//
// Related Topics 字符串 👍 456 👎 0

package leetcode.editor.cn;
public class TiHuanKongGeLcof {
    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();
        String s = solution.replaceSpace("We are happy.");
        System.out.println(s);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        String s1 = s.replaceAll(" ", "%20");
        return s1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
