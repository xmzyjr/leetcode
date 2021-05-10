package feture.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lanshan
 */
public class Offer50 {

    /**
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     *
     * 示例:
     *
     * s = "abaccdeff"
     * 返回 "b"
     *
     * s = ""
     * 返回 " "
     *  
     *
     * 限制：
     *
     * 0 <= s 的长度 <= 50000
     */
    public char firstUniqChar(String s) {
        if (s == null || s.equals("")) {
            return ' ';
        }
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (!map.containsKey(aChar)) {
                map.put(aChar, 1);
            } else {
                Integer integer = map.get(aChar);
                map.put(aChar, integer + 1);
            }
        }
        for (char aChar : chars) {
            if (map.get(aChar) == 1)
                return aChar;
        }
        return ' ';
    }
}
