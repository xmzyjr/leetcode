package feture.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lanshan
 */
public class Offer29 {
    
    int[] res;
    int[][] dir = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[][] t;
    int count;
    int resIndex;
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        t = new int[matrix.length][matrix[0].length];
        count = matrix.length * matrix[0].length;
        res = new int[count];
        resIndex = 0;
        find(matrix, 0, 0, 0);
        return res;
    }

    private void find(int[][] matrix, int x, int y, int index) {
        t[x][y] = 1;
        res[resIndex++] = matrix[x][y];
        if (needChange(matrix, x + dir[index][0], y + dir[index][1])) {
            if (resIndex == count)
                return;
            int nextIndex = (index + 1) % 4;
            find(matrix, x + dir[nextIndex][0], y + dir[nextIndex][1], nextIndex);
        } else {
            find(matrix, x + dir[index][0], y + dir[index][1], index);
        }
    }

    private boolean needChange(int[][] matrix, int x, int y) {
        return x < 0 || y < 0 || x == matrix.length || y == matrix[0].length || t[x][y] == 1;
    }

    public static void main(String[] args) {
        Offer29 o = new Offer29();
        System.out.println(Arrays.toString(o.spiralOrder(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }
}
