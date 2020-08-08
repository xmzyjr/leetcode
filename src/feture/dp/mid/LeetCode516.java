
package feture.dp.mid;

/**
 * @author lanshan
 */
public class LeetCode516 {

    int[][] num;

    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;
        char[] chars = s.toCharArray();
        char[] newChars = new char[2 * chars.length - 1];
        for (int i = 0, j = 0; i < newChars.length; i += 2, j++) {
            newChars[i] = chars[j];
            if (i != newChars.length - 1)
                newChars[i + 1] = '#';
        }
        num = new int[newChars.length][newChars.length];
        int max = 0;
        for (int i = 1; i < newChars.length; i++) {
            max = Math.max(max, find(newChars, i, i));
        }
        return max;
    }

    private int find(char[] s1, int index1, int index2) {
        if (index1 < 0 || index2 >= s1.length)
            return 0;

        index1 = (index1 & 1) == 1 ? index1 - 1 : index1;
        index2 = (index2 & 1) == 1 ? index2 + 1 : index2;
        if (num[index1][index2] != 0)
            return num[index1][index2];
        if (s1[index1] == s1[index2]) {
            int max = Math.max(Math.max(find(s1, index1 - 2, index2), find(s1, index1, index2 + 2)),
                    find(s1, index1 - 2, index2 + 2) + (index1 == index2 ? 1 : 2));
            num[index1][index2] = max;
            return num[index1][index2];
        } else {
            int max = Math.max(find(s1, index1 - 2, index2), find(s1, index1, index2 + 2));
            num[index1][index2] = max;
            return num[index1][index2];
        }
    }

    public int longestPalindromeSubseq2(String s) {
        if (s == null || s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;
        char[] chars = s.toCharArray();
        char[] newChars = new char[2 * chars.length - 1];
        for (int i = 0, j = 0; i < newChars.length; i += 2, j++) {
            newChars[i] = chars[j];
            if (i != newChars.length - 1)
                newChars[i + 1] = '#';
        }

        num = new int[newChars.length][newChars.length];
        for (int i = 0; i < num.length; i += 2) {
            for (int j = num[i].length - 1; j >= 0; j -= 2) {
                int num1 = i - 2 < 0 ? 0 : num[i - 2][j];
                int num2 = j + 2 >= num.length ? 0 : num[i][j + 2];
                int max = Math.max(num1, num2);
                if (newChars[i] == newChars[j]) {
                    num[i][j] = Math.max(max, ((i - 2 < 0 || j + 2 >= num.length) ? 0 : num[i - 2][j + 2]) + 1);
                } else {
                    num[i][j] = max;
                }
            }
        }
        return num[num.length - 1][0];
    }

    public static void main(String[] args) {
        LeetCode516 l = new LeetCode516();
        System.out.println(l.longestPalindromeSubseq2("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg"));
    }

}
