package l201904;

import java.util.*;

/**
 * @author lanshan
 */
public class LeetCode3 {

    /**
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */

    // 滑动窗口
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Set<Character> map = new HashSet<>();
        List<Character> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            if (list.size() == 0) {
                list.add(chars[i]);
                map.add(chars[i]);
            } else {
                if (map.contains(chars[i])) {
                    max = list.size() > max ? list.size() : max;
                    list = cleanListAndMap(list, map, chars[i]);
                }
                list.add(chars[i]);
                map.add(chars[i]);
            }
        }
        max = list.size() > max ? list.size() : max;
        return max;
    }

    List<Character> cleanListAndMap(List<Character> list, Set<Character> map, char c) {
        List<Character> re = new ArrayList<>();
        int i;
        for (i = 0; i < list.size(); i++) {
            map.remove(list.get(i));
            if (list.get(i) == c) {
                break;
            }
        }
        for (int j = i + 1; j < list.size(); j++) {
            re.add(list.get(j));
        }
        return re;
    }

}
