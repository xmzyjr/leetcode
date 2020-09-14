
package feture.greedy.mid;

/**
 * @author lanshan
 */
public class LeetCode861 {

    public int matrixScore(int[][] A) {
        if (A == null || A.length == 0)
            return 0;
        int row = A.length;
        for (int i = 0; i < row; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < A[i].length; j++) {
                    A[i][j] ^= 1;
                }
            }
        }
        int col = A[0].length;
        int res = (1 << (col - 1)) * row;
        for (int i = 1; i < col; i++) {
            int n = 0;
            for (int j = 0; j < row; j++) {
                n += (A[j][i] == 1 ? 1 : 0);
            }
            n = Math.max(n, row - n);
            res += (1 << (col - 1 - i)) * n;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode861 l = new LeetCode861();
        System.out.println(l.matrixScore(new int[][] {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}}));
    }
}
