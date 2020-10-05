package feture.greedy.mid;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class LeetCode1433 {
    public boolean checkIfCanBreak(String s1, String s2) {
        boolean check1 = true, check2 = true;
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        check1 = check(chars1, chars2);
        check2 = check(chars2, chars1);
        return check1 || check2;
    }
    
    private boolean check(char[] chars1, char[] chars2) {
        boolean res = true;
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] < chars2[i]) {
                res = false;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode1433 l = new LeetCode1433();
        System.out.println(l.checkIfCanBreak("abc", "xya"));
        System.out.println(l.checkIfCanBreak("abe", "acd"));
        System.out.println(l.checkIfCanBreak("leetcodee", "interview"));
    }
}

