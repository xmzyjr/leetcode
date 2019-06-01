
package l201904;

/**
 * @author lanshan
 */
public class LeetCode32 {

    /**
     * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
     * 示例 1:
     * 输入: "(()"
     * 输出: 2
     * 解释: 最长有效括号子串为 "()"
     * 示例 2:
     * 输入: ")()())"
     * 输出: 4
     * 解释: 最长有效括号子串为 "()()"
     * （（（（））））（）（）（）（）））（（（）（（（（)
     */

    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        int max = 0, now = 0, valid = 0, sum = 0;
        for (char aChar : chars) {
            sum += (aChar == '(') ? 1 : -1;
            now++;
            if (sum < 0) {
                max = max > valid ? max : valid;
                valid = 0;
                now = 0;
                sum = 0;
            } else if (sum == 0) {
                valid = now;
            }
        }
        return max;
    }
}
