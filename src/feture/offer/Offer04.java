package feture.offer;

/**
 * @author lanshan
 */
public class Offer04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        int x = 0, y = matrix[0].length - 1;
        while (x < matrix.length && y >= 0 && matrix[x][y] != target) {
            if (matrix[x][y] > target) {
                y--;
            } else if (matrix[x][y] < target) {
                x++;
            }
        }
        if (x == matrix.length || y < 0)
            return false;
        return matrix[x][y] == target;
    }
}
