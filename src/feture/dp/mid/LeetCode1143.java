
package feture.dp.mid;

/**
 * @author lanshan
 */
public class LeetCode1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0)
            return 0;
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        return find(s1, s2, 0, 0);
    }

    private int find(char[] s1, char[] s2, int index1, int index2) {
        if (index1 == s1.length || index2 == s2.length)
            return 0;
        if (s1[index1] != s2[index2]) {
            return Math.max(find(s1, s2, index1 + 1, index2), find(s1, s2, index1, index2 + 1));
        } else {
            return Math.max(Math.max(find(s1, s2, index1 + 1, index2), find(s1, s2, index1, index2 + 1)),
                    find(s1, s2, index1 + 1, index2 + 1) + 1);
        }
    }

    private int longestCommonSubsequence2(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0)
            return 0;
        int[][] res = new int[text1.length() + 1][text2.length() + 1];
        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                int temp = Math.max(res[i + 1][j], res[i][j + 1]);
                if (text1.charAt(i) != text2.charAt(j)) {
                    res[i][j] = temp;
                } else {
                    res[i][j] = Math.max(temp, res[i + 1][j + 1] + 1);
                }
            }
        }
        return res[0][0];
    }

    public static void main(String[] args) {
        LeetCode1143 l = new LeetCode1143();
        System.out.println(l.longestCommonSubsequence("abcde", "ace"));
    }
}
