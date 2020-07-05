package feture.binary.search.easy;

/**
 * @author lanshan
 */
public class LeetCode392 {
    class Solution {
        public boolean isSubsequence(String s, String t) {
            if (s == null || s.length() == 0)
                return true;
            int sIndex = 0, tIndex =0;
            while (sIndex<s.length() && tIndex<t.length()) {
                if (s.charAt(sIndex) == t.charAt(tIndex)) {
                    sIndex++;
                }
                tIndex++;
            }
            return sIndex == s.length();
        }
    }
}
