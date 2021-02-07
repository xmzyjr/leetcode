package feture.ms;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lanshan
 */
public class M0104 {
    /**
     * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
     *
     * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
     *
     * 回文串不一定是字典当中的单词。
     *
     *  
     *
     * 示例1：
     *
     * 输入："tactcoa"
     * 输出：true（排列有"tacocat"、"atcocta"，等等）
     */
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;
        Map<Character, Integer> map = new HashMap<>(s.length() / 2 + 1);
        char[] chars = s.toCharArray();
        for (char c : chars) {
            Integer integer = map.get(c);
            if (integer == null) {
                map.put(c, 1);
            } else {
                if (integer == 0)
                    map.put(c, 1);
                else if (integer == 1)
                    map.put(c, 0);
            }
        }
        int count = 0;
        for (Integer value : map.values()) {
            count += value;
        }
        return count <= 1;
    }
}
