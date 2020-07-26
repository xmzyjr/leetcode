
package feture.dp.mid;

/**
 * @author lanshan
 */
public class LeetCode474 {

    public int findMaxForm2(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0)
            return 0;
        return find(strs, 0, m, n);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0)
            return 0;
        int[] mZero = new int[strs.length];
        int[] nOne = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '0')
                    mZero[i]++;
                else
                    nOne[i]++;
            }
        }
        int[][][] num = new int[strs.length][m+1][n+1];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    int zero = j - mZero[i];
                    int one = k - nOne[i];
                    if (zero < 0 || one < 0) {
                        num[i][j][k] = i - 1 < 0 ? 0 : num[i - 1][j][k]; 
                        continue;
                    }
                    num[i][j][k] = i - 1 < 0 ? 1 : Math.max(num[i-1][j][k], num[i-1][zero][one] + 1);
                }
            }
        }
        return num[strs.length-1][m][n];
    }

    public int findMaxForm3(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0)
            return 0;
        int[][] num = new int[m+1][n+1];
        for (int i = 0; i < strs.length; i++) {
            int mZero = 0, nOne = 0;
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0')
                    mZero++;
                else
                    nOne++;
            }
            for (int j = m; j >= mZero ; j--) {
                for (int k = n; k >= nOne; k--) {
                    num[j][k] = Math.max(num[j][k], num[j - mZero][k - nOne] + 1);
                }
            }
        }
        return num[m][n];
    }

    private int find(String[] strs, int index, int m, int n) {
        if (index == strs.length && m == 0 && n == 0)
            return 0;
        if (index >= strs.length || m < 0 || n < 0)
            return -1;
        String str = strs[index];
        int mZero = 0, nOne = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0')
                mZero++;
            else
                nOne++;
        }
        int i = find(strs, index + 1, m, n);
        int j = find(strs, index + 1, m - mZero, n - nOne) + 1;
        return Math.max(i, j);
    }

    public static void main(String[] args) {
        LeetCode474 l = new LeetCode474();
        System.out.println(l.findMaxForm3(new String[] { "10","0001","111001","1","0" }, 5, 3));
    }
}
