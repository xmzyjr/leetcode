package feture.util;

/**
 * @author lanshan
 */
public class LeetCodeUtil {

    public static void print(int[][] num) {
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                System.out.print(num[i][j] + " ");
            }
            System.out.println();
        }
    }
}
