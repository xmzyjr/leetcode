package feture.game.l0920;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lanshan
 */
public class LeetCode5520 {

    private Set<String> charMap;
    int max;
    public int maxUniqueSplit(String s) {
        if (s == null || s.length() == 0)
            return 0;
        charMap = new HashSet<>(16);
        max = 0;
        find(s);
        return max;
    }

    private void find(String s) {
        for (int i = 1; i <= s.length(); i++) {
            String s1 = s.substring(0, i);
            if (charMap.contains(s1))
                continue;
            charMap.add(s1);
            String s2 = s.substring(i);
            if (s2.length() == 0) {
                max = Math.max(max, charMap.size());
                charMap.remove(s1);
                return;
            }
            find(s2);
            charMap.remove(s1);
        }
    }

    public static void main(String[] args) {
        LeetCode5520 l = new LeetCode5520();
        System.out.println(l.maxUniqueSplit("ababccc"));
    }
}
