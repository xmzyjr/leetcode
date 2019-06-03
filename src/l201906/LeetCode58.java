
package l201906;

/**
 * @author lanshan
 */
public class LeetCode58 {

    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        String[] s1 = s.split(" ");
        return s1[s1.length - 1].length();
    }
}
