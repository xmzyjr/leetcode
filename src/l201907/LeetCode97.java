
package l201907;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lanshan
 */
public class LeetCode97 {

    /**
     * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
     * 示例 1:
     * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
     * 输出: true
     * 示例 2:
     * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
     * 输出: false
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        int len1 = s1.length();
        int len2 = s2.length();
        return check(s1, s2, 0, 0, s3, 0, new HashMap<String, Boolean>());
    }

    public boolean check(String s1, String s2, int index1, int index2, String s3, int index3,
                         Map<String, Boolean> map) {
        if (index1 > s1.length() || index2 > s2.length()) {
            return false;
        }
        if (index3 != s3.length() && (index1 == s1.length() || s1.charAt(index1) != s3.charAt(index3))
                && (index2 == s2.length() || s2.charAt(index2) != s3.charAt(index3))) {
            return false;
        }
        if (index3 == s3.length() && index1 == s1.length() && index2 == s2.length()) {
            return true;
        }
        boolean check1 = false;
        boolean check2 = false;
        if (index1 != s1.length() && s1.charAt(index1) == s3.charAt(index3)) {
            int next = index1 + 1;
            String s = next + "|" + index2 + "|" + index3;
            Boolean temp = map.get(s);
            if (temp == null) {
                check1 = check(s1, s2, next, index2, s3, index3 + 1, map);
                map.put(s, check1);
            } else {
                check1 = temp;
            }
        }
        if (index2 != s2.length() && s2.charAt(index2) == s3.charAt(index3)) {
            int next = index2 + 1;
            String s = next + "|" + next + "|" + index3;
            Boolean temp = map.get(s);
            if (temp == null) {
                check2 = check(s1, s2, index1, next, s3, index3 + 1, map);
                map.put(s, check2);
            } else {
                check2 = temp;
            }
        }
        return check1 || check2;
    }

    public static void main(String[] args) {
        LeetCode97 l = new LeetCode97();
        System.out.println(l.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
