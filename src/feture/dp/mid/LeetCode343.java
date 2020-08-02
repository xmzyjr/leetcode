
package feture.dp.mid;

/**
 * @author lanshan
 */
public class LeetCode343 {

    int[][] res;
    public int integerBreak(int n) {
        if (n <= 1)
            return 0;
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + 1;
        }
        res = new int[sum.length][sum.length];
        find(sum, 1, sum.length - 1);
        return res[1][sum.length-1];
    }

    private int find(int[] sum, int i, int j) {
        if (res[i][j]>0) {
            return res[i][j];
        }
        if (i == j) {
            return 1;
        }
        int ans = 0;
        for (int k = i; k < j; k++) {
            int left = find(sum, i, k);
            int right = find(sum, k + 1, j);
            int tempMax = Math.max((sum[j] - sum[k]) * (sum[k] - sum[i - 1]), left * right);
            tempMax = Math.max(tempMax, right*(sum[k] - sum[i - 1]));
            tempMax = Math.max(tempMax, (sum[j] - sum[k]) * left);
            ans = Math.max(ans, tempMax);
        }
        res[i][j] = ans;
        return ans;
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
        LeetCode343 l = new LeetCode343();
        System.out.println(l.integerBreak(58));
    }

}
