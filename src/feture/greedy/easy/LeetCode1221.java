package feture.greedy.easy;

/**
 * @author lanshan
 */
public class LeetCode1221 {

    public int balancedStringSplit(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int count = 0;
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L')
                l++;
            else
                r++;
            if (l == r && l != 0) {
                count++;
                l = r = 0;
            }
        }
        return count;
    }
}
