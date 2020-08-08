
package feture.dp.hard;

/**
 * @author lanshan
 */
public class LeetCode1000 {

    public int mergeStones(int[] stones, int K) {
        if (stones == null || stones.length == 0 || K > stones.length || (stones.length - K) % (K - 1) != 0)
            return -1;
        int[] sum = new int[stones.length + 1];
        sum[1] = stones[0];
        for (int i = 2; i < stones.length; i++) {
            sum[i] = stones[i - 1] + sum[i - 1];
        }
        int[][] res = new int[stones.length + 1][stones.length + 1];
        for (int len = 1; len <= stones.length; len++) {
            if (len<K || (len-K)%(K-1)!=0) {
                continue;
            }
            for (int i = 1; i <= stones.length; i++) {
                int j = len + i - 1;
                for (int k = i; k < j && j<= stones.length; k++) {
                    int left =0, right = 0;
                    if (k-i+1 == K)
                        left = sum[k] - sum[i - 1];
//                    if (j-k == K)
//                        right =
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LeetCode1000 l = new LeetCode1000();
        l.mergeStones(new int[]{3,5,1,2,6}, 3);
    }

    private void print(Integer[][] res) {
        for (int i = 0; i < res.length; i++) {
            for (int i1 = 0; i1 < res[i].length; i1++) {
                System.out.print(res[i][i1]+ " ");
            }
            System.out.println();
        }
    }
}
