package feture.dp.mid;

/**
 * @author lanshan
 */
public class LeetCode62 {
    public int uniquePaths(int m, int n) {
        if (m<=0 || n<=0)
            return 0;
        int[][] num = new int[n+1][m+1];
        num[n-1][m-1] = 1;
        for (int i = num.length - 2; i >= 0; i--) {
            for (int j = num[i].length - 2; j >= 0; j--) {
                if (i==n-1 && j == m-1)
                    continue;
                num[i][j] = num[i+1][j] + num[i][j+1];
            }
        }
        print(num);
        return num[0][0];
    }

    private void print(int[][] num) {
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                System.out.print(num[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LeetCode62 l = new LeetCode62();
        l.uniquePaths(3,2);
    }
}
