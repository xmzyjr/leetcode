package feture.game.l1115;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class LeetCode5603 {

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;
        int[] num1 = new int[26];
        int[] num2 = new int[26];
        count(num1, word1);
        count(num2, word2);
        boolean check = check(num1, num2);
        if (!check)
            return false;
        Arrays.sort(num1);
        Arrays.sort(num2);
        for (int i = 0; i < 26; i++) {
            if (num1[i] != num2[i])
                return false;
        }
        return true;
    }

    private void count(int[] num1, String word) {
        for (char c : word.toCharArray()) {
            num1[c - 'a']++;
        }
    }

    private boolean check(int[] num1, int[] num2) {
        for (int i = 0; i < 26; i++) {
            if ((num1[i]!=0 && num2[i]==0) || (num1[i]==0 && num2[i]!=0))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode5603 l = new LeetCode5603();
        System.out.println(l.closeStrings("abc", "bca"));
        System.out.println(l.closeStrings("a", "aa"));
        System.out.println(l.closeStrings("cabbba", "abbccc"));
        System.out.println(l.closeStrings("cabbba", "aabbss"));
    }
}
