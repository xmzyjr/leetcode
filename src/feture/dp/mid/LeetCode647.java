
package feture.dp.mid;

/**
 * @author lanshan
 */
public class LeetCode647 {

    public int countSubstrings(String s) {
        if (s == null)
            return 0;
        int length = s.length();
        if (length == 0 || length == 1)
            return length;
        int ans = 0;
        for (int i = 0; i < 2 * length - 1; i++) {
            int left = i / 2;
            int right = left + i % 2;
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
}
