package feture.ms;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lanshan
 */
public class M0108 {

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int x = matrix.length;
        int y = matrix[0].length;
        Set<Integer> xLine = new HashSet<>(x);
        Set<Integer> yLine = new HashSet<>(y);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix[i][j] == 0) {
                    xLine.add(i);
                    yLine.add(j);
                }
            }
        }
        for (Integer xNum : xLine) {
            for (int i = 0; i < y; i++) {
                matrix[xNum][i] = 0;
            }
        }
        for (Integer yNum : yLine) {
            for (int i = 0; i < x; i++) {
                matrix[i][yNum] = 0;
            }
        }
    }

    public static void main(String[] args) {
        M0108 m = new M0108();
        m.setZeroes(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
    }
}
