package feture.bd;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lanshan
 */
public class LeetCode139 {
    /**
     *给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
     *
     * 说明：
     *
     * 拆分时可以重复使用字典中的单词。
     * 你可以假设字典中没有重复的单词。
     * 示例 1：
     *
     * 输入: s = "leetcode", wordDict = ["leet", "code"]
     * 输出: true
     * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
     * 示例 2：
     *
     * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
     * 输出: true
     * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     *      注意你可以重复使用字典中的单词。
     * 示例 3：
     *
     * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * 输出: false
     */
    Set<String> set;
    Boolean[][] map;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        map = new Boolean[s.length() + 2][s.length() + 2];
        return find(s, 0, 1);
    }

    private boolean find(String s, int left, int right) {
        if (left == s.length()) {
            return true;
        }
        if (map[left][right] != null) {
            return map[left][right];
        }
        boolean temp = false;
        for (int i = right; i <= s.length(); i++) {
            if (set.contains(s.substring(left, i))) {
                temp |= find(s, i, i + 1);
            }
        }
        map[left][right] = temp;
        return temp;
    }

    public static void main(String[] args) {
        LeetCode139 l = new LeetCode139();
        System.out.println(l.wordBreak("leetcode", Arrays.asList("leet", "code")));
    }
}
