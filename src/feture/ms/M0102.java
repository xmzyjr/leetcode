package feture.ms;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lanshan
 */
public class M0102 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        } else if (s1 == null) {
            return false;
        } else if (s2 == null) {
            return false;
        } else {
            if (s1.length() == 0 && s2.length() == 0)
                return true;
            if (s1.length() != s2.length())
                return false;
            char[] chars = s1.toCharArray();
            Map<Character, Integer> map = new HashMap<>(chars.length);
            for (char aChar : chars) {
                map.merge(aChar, 1, Integer::sum);
            }
            char[] chars1 = s2.toCharArray();
            for (char c : chars1) {
                map.merge(c, -1, Integer::sum);
            }
            for (Integer value : map.values()) {
                if (value != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
