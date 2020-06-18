package feture.daily;

/**
 * @author lanshan
 */
public class LeetCode125 {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            while (left <= s.length()-1 && isChartOrNum(s.charAt(left))) {
                left++;
            }
            while (right >= 0 && isChartOrNum(s.charAt(right))) {
                right--;
            }
            if (left > right) {
                return true;
            }
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
    
    private boolean isChartOrNum(char ch) {
        return (ch < 'a' || ch > 'z') && (ch < '0' || ch > '9');
    }

}
