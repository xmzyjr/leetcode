package feture.util;

/**
 * @author lanshan
 */
public class LeetCodeUtil {

    public static void print(int[][] num) {
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                System.out.printf("%3d",num[i][j]);
            }
            System.out.println();
        }
    }

    public static void printList(int[] num) {
        for (int i : num) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void printList(boolean[] num) {
        for (boolean i : num) {
            System.out.print((i ? "T" : "F") + " ");
        }
        System.out.println();
    }
}
