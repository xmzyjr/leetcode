package feture.offer;

/**
 * @author lanshan
 */
public class Offer19 {

    /**
     * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
     * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
     *
     * 示例 1:
     *
     * 输入:
     * s = "aa"
     * p = "a"
     * 输出: false
     * 解释: "a" 无法匹配 "aa" 整个字符串。
     * 示例 2:
     *
     * 输入:
     * s = "aa"
     * p = "a*"
     * 输出: true
     * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
     * 示例 3:
     *
     * 输入:
     * s = "ab"
     * p = ".*"
     * 输出: true
     * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
     * 示例 4:
     *
     * 输入:
     * s = "aab"
     * p = "c*a*b"
     * 输出: true
     * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
     * 示例 5:
     *
     * 输入:
     * s = "mississippi"
     * p = "mis*is*p*."
     * 输出: false
     * s 可能为空，且只包含从 a-z 的小写字母。
     * p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。
     */
    Boolean[][] map;
    public boolean isMatch(String s, String p) {
        if (".*".equals(p))
            return true;
        char[] s1 = s.toCharArray();
        char[] p1 = p.toCharArray();
        map = new Boolean[s1.length + 1][p1.length + 1];
        return find(s1, p1, 0, 0);
    }

    private boolean find(char[] s1, char[] p1, int index1, int index2) {
        if (index1 <= s1.length && index2 <= p1.length && map[index1][index2] != null) {
            return map[index1][index2];
        }
        if (index1 == s1.length && index2 == p1.length)
            return true;
        if (index2 == p1.length)
            return false;
        Boolean res = null;
        if (index1 != s1.length) {
            if (s1[index1] == p1[index2] || p1[index2] == '.') {
                res = find(s1, p1, index1 + 1, index2 + 1);
            } else if (p1[index2] == '*') {
                if (index2 == 0) {
                    res = find(s1, p1, index1, index2 + 1);
                } else if (p1[index2 - 1] == s1[index1] || p1[index2 - 1] == '.') {
                    res = find(s1, p1, index1 + 1, index2 + 1) || find(s1, p1, index1 + 1, index2)
                            || find(s1, p1, index1, index2 + 1);
                } else {
                    res = find(s1, p1, index1, index2 + 1);
                }
            }
            if (res == null) {
                res = index2 + 1 < p1.length && p1[index2 + 1] == '*' && find(s1, p1, index1, index2 + 2);
            }
        } else {
            res = p1[index2] == '*' && find(s1, p1, index1, index2 + 1)
                    || (index2 + 1 < p1.length && p1[index2 + 1] == '*' && find(s1, p1, index1, index2 + 2));
        }
        map[index1][index2] = res;
        return res;
    }

    /**
     * "ab"
     * ".*c"
     *
     * "aaa"
     * "ab*a*c*a"
     * 
     * "a"
     * "ab*"
     */
    public static void main(String[] args) {
        Offer19 o = new Offer19();
        System.out.println(o.isMatch("mississippi", "mis*is*p*."));
        System.out.println(o.isMatch("aab", "c*a*b"));
        System.out.println(o.isMatch("ab", ".*c"));
        System.out.println(o.isMatch("aaa", "ab*a*c*a"));
        System.out.println(o.isMatch("a", "ab*"));
    }

}
