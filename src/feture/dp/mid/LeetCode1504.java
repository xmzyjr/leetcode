
package feture.dp.mid;

import feture.util.LeetCodeUtil;

/**
 * @author lanshan
 */
public class LeetCode1504 {

    public int numSubmat(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] != 0)
                    res[i][j] = mat[i][j] + (j - 1 >= 0 ? res[i][j - 1] : 0);
            }
        }

        LeetCodeUtil.print(res);

        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k >= 0; k--) {
                    min = Math.min(min, res[k][j]);
                    sum += min;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        LeetCode1504 l = new LeetCode1504();
        System.out.println(l.numSubmat(new int[][] { { 1, 1, 0 }, { 1, 1, 1 } }));
//        System.out.println(l.numSubmat(new int[][] { { 1, 0, 1 }, { 1, 1, 0 }, { 1, 1, 0 } }));
    }
}
