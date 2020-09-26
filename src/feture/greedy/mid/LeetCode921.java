package feture.greedy.mid;

/**
 * @author lanshan
 */
public class LeetCode921 {

    public int minAddToMakeValid(String S) {
        if (S == null || S.length() == 0)
            return 0;
        int count = 0, left = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(')
                left++;
            else {
                if (left > 0) {
                    left--;
                } else {
                    count++;
                }
            }
        }
        count += left;
        return count;
    }

    public static void main(String[] args) {
        LeetCode921 l = new LeetCode921();
        System.out.println(l.minAddToMakeValid("())"));
        System.out.println(l.minAddToMakeValid("((("));
        System.out.println(l.minAddToMakeValid("()"));
        System.out.println(l.minAddToMakeValid("()))(("));
    }
}
