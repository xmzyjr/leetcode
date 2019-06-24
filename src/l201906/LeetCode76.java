
package l201906;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lanshan
 */
public class LeetCode76 {

    /**
     * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
     * 示例：
     * 输入: S = "ADOBECODEBANC", T = "ABC"
     * 输出: "BANC"
     * 说明：
     * 如果 S 中不存这样的子串，则返回空字符串 ""。
     * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
     */
    public String minWindow(String s, String t) {
        char[] s1 = s.toCharArray();
        int minLeft = 0, minRight = -1, left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }
        int len = map.size();
        Map<Character, Integer> set = new HashMap<>();
        int need = 0;
        while (right < s1.length) {
            Integer count = set.getOrDefault(s1[right], 0);
            set.put(s1[right], count + 1);
            if (map.containsKey(s1[right]) && (map.get(s1[right]).intValue() == set.get(s1[right]).intValue())) {
                need++;
            }
            while (need == len) {
                if (minRight == -1 || (right - left) < (minRight - minLeft)) {
                    minRight = right;
                    minLeft = left;
                }
                Integer count1 = set.getOrDefault(s1[left], 0);
                set.put(s1[left], count1 - 1);
                if (map.containsKey(s1[left]) && map.get(s1[left]) > set.get(s1[left])) {
                    need--;
                }
                left++;

            }
            right++;
        }

        return minRight == -1 ? "" : s.substring(minLeft, minRight + 1);
    }

    public static void main(String[] args) {
        LeetCode76 l = new LeetCode76();
        System.out.println(l.minWindow("ADOBECODEBANC", "ABC"));
    }
}
