package feture.bd;

/**
 * @author lanshan
 */
public class LeetCode48 {
    public void rotate(int[][] matrix) {
        if (matrix.length == 1)
            return;
        int col = matrix.length;
        for (int i = 0; i < col / 2; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                swap(matrix, i, j, col - 1 - i, j);
            }
        }
        for (int i = 0; i < col; i++) {
            for (int j = i+1; j < matrix[i].length; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    private void swap(int[][] m, int i, int j, int i1, int j1) {
        int temp = m[i][j];
        m[i][j] = m[i1][j1];
        m[i1][j1] = temp;
    }
}
