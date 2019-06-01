
package l201905;

/**
 * @author lanshan
 */
public class LeetCode44 {

    /**
     * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
     * '?' 可以匹配任何单个字符。
     * '*' 可以匹配任意字符串（包括空字符串）。
     * 两个字符串完全匹配才算匹配成功。
     * 说明:
     * s 可能为空，且只包含从 a-z 的小写字母。
     * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
     * 示例 1:
     * 输入:
     * s = "aa"
     * p = "a"
     * 输出: false
     * 解释: "a" 无法匹配 "aa" 整个字符串。
     * 示例 2:
     * 输入:
     * s = "aa"
     * p = "*"
     * 输出: true
     * 解释: '*' 可以匹配任意字符串。
     * 示例 3:
     * 输入:
     * s = "cb"
     * p = "?a"
     * 输出: false
     * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
     * 示例 4:
     * 输入:
     * s = "adceb"
     * p = "*a*b"
     * 输出: true
     * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
     * 示例 5:
     * 输入:
     * s = "acdcb"
     * p = "a*c?b"
     * 输入: false
     */

    public boolean isMatch(String s, String p) {
        char[] s1 = s.toCharArray();
        char[] p1 = p.toCharArray();
        return dpMatch(s1, p1);
    }

    public boolean math(char[] s, char[] p, int index1, int index2) {
        if (index2 >= p.length) {
            return index1 >= s.length;
        }
        boolean m1 = index1 < s.length && (s[index1] == p[index2] || p[index2] == '?');
        if (index2 < p.length - 1 && p[index2 + 1] == '*') {
            return math(s, p, index1, index2 + 2) || (m1 && math(s, p, index1 + 1, index2));
        } else {
            return m1 && math(s, p, index1 + 1, index2 + 1);
        }
    }

    public boolean match1(char[] s, char[] p, int index1, int index2) {
        if (index2 >= p.length) {
            return index1 >= s.length;
        }
        if (index1 == s.length) {
            return p[index2] == '*' && (index2 == p.length - 1 || checkStar(p, index2));
        }
        boolean m1 = index1 < s.length && (s[index1] == p[index2] || p[index2] == '?');
        if (p[index2] == '*') {
            return match1(s, p, index1, index2 + 1) || match1(s, p, index1 + 1, index2);
        } else {
            return m1 && match1(s, p, index1 + 1, index2 + 1);
        }
    }

    /**
     * "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba"
     * "a*******b"
     */
    public boolean checkStar(char[] p, int index) {
        for (int i = index; i < p.length; i++) {
            if (p[i] != '*') {
                return false;
            }
        }
        return true;
    }

    /**
     * dp
     */
    public boolean dpMatch(char[] s, char[] p) {
        int sLen = s.length;
        int pLen = p.length;
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        for (int i = 0; i <= sLen; i++) {
            dp[i][pLen] = (i >= sLen);
        }
        for (int i = 0; i < pLen; i++) {
            dp[sLen][i] = p[i] == '*' && (i >= p.length - 1 || checkStar(p, i));
        }

        for (int i = sLen - 1; i >= 0; i--) {
            for (int j = pLen - 1; j >= 0; j--) {
                if (p[j] == '*') {
                    dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
                } else {
                    boolean m1 = i < s.length && (s[i] == p[j] || p[j] == '?');
                    dp[i][j] = m1 && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        LeetCode44 l = new LeetCode44();
        System.out.println(l.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"));
    }
}
