package feture.bd;

/**
 * @author lanshan
 */
public class LongestPalindromicSubstring {
    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * 示例 2：
     *
     * 输入：s = "cbbd"
     * 输出："bb"
     * 示例 3：
     *
     * 输入：s = "a"
     * 输出："a"
     * 示例 4：
     *
     * 输入：s = "ac"
     * 输出："a"
     *  
     *
     * 提示：
     *
     * 1 <= s.length <= 1000
     * s 仅由数字和英文字母（大写和/或小写）组成
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return s;
        int left = 0, right = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int i1 = find(chars, i, i);
            int i2 = find(chars, i, i + 1);
            int l = Math.max(i1, i2);
            if (l > right - left + 1) {
                left = i - (l - 1) / 2;
                right = i + l / 2;
            }
        }
        return s.substring(left, right + 1);
    }

    private int find(char[] chars, int left, int right) {
        while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        System.out.println(l.longestPalindrome("ccc"));
    }
}
