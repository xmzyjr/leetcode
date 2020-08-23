
package feture.dp.mid;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lanshan
 */
public class LeetCode813 {

    /**
     * 我们将给定的数组 A 分成 K 个相邻的非空子数组 ，我们的分数由每个子数组内的平均值的总和构成。计算我们所能得到的最大分数是多少。
     *
     * 注意我们必须使用 A 数组中的每一个数进行分组，并且分数不一定需要是整数。
     *
     * 示例:
     * 输入:
     * A = [9,1,2,3,9]
     * K = 3
     * 输出: 20
     * 解释:
     * A 的最优分组是[9], [1, 2, 3], [9]. 得到的分数是 9 + (1 + 2 + 3) / 3 + 9 = 20.
     * 我们也可以把 A 分成[9, 1], [2], [3, 9].
     * 这样的分组得到的分数为 5 + 2 + 6 = 13, 但不是最大值.
     */
    Map<String, Double> map;
    public double largestSumOfAverages2(int[] A, int K) {
        if (A == null || A.length == 0 || K == 0 || K > A.length)
            return 0;
        int[] sum = new int[A.length];
        sum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            sum[i] = sum[i - 1] + A[i];
        }
        map = new HashMap<>(A.length * A.length);
        return find(sum, K, 0, A.length - 1);
    }

    private double find(int[] sum, int k, int i, int j) {
        String key = k + "_" + i + "_" + j;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (k == (j - i + 1)) {
            double res = getSum(sum, i, j)*1.0;
            map.put(key, res);
            return res;
        }
        if (k == 1) {
            double res = getSum(sum, i, j) * 1.0 / (j - i + 1);
            map.put(key, res);
            return res;
        }
        double max = Integer.MIN_VALUE;
        for (int t = i; t < j; t++) {
            for (int t1 = 1; t1 < k; t1++) {
                double left = find(sum, t1, i, t);
                double right = find(sum, k - t1, t + 1, j);
                max = Math.max(max, left + right);
            }
        }
        map.put(key, max);
        return max;
    }

    private int getSum(int[] sum, int i, int j) {
        if (i == 0)
            return sum[j];
        return sum[j] - sum[i - 1];
    }

    public double largestSumOfAverages3(int[] A, int K) {
        if (A == null || A.length == 0 || K == 0 || K > A.length)
            return 0;
        int[] sum = new int[A.length];
        sum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            sum[i] = sum[i - 1] + A[i];
        }
        map = new HashMap<>();
        return find2(sum, K, A.length - 1);
    }

    private double find2(int[] sum, int k, int index) {
        String key = k + "_" + index;
        if (map.containsKey(key))
            return map.get(key);
        if (k > (index + 1) || index < 0) {
            map.put(key, 0.0);
            return 0;
        }
        if (k == 1) {
            double value = sum[index] * 1.0 / (index + 1);
            map.put(key, value);
            return value;
        }
        double max = Integer.MIN_VALUE;
        for (int i = index; i >= 0; i--) {
            double temp = find2(sum, k - 1, i - 1) + getSum(sum, i, index) * 1.0 / (index - i + 1);
            max = Math.max(temp, max);
        }
        map.put(key, max);
        return max;
    }

    /**
     * final
     */
    public double largestSumOfAverages(int[] A, int K) {
        if (A == null || A.length == 0 || K == 0 || K > A.length)
            return 0;
        int[] sum = new int[A.length];
        sum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            sum[i] = sum[i - 1] + A[i];
        }

        double[][] res = new double[K+1][sum.length];
        for (int i = 0; i < A.length; i++) {
            res[1][i] = sum[i] * 1.0 / (i + 1);
        }
        for (int i = 2; i < res.length; i++) {
            for (int j = res[i].length - 1; j >= 0; j--) {
                if (i>(j+1)) {
                    res[i][j] = 0;
                    continue;
                }
                double max = Integer.MIN_VALUE;
                for (int t = j; t >= 0; t--) {
                    max = Math.max(max, (t - 1 < 0 ? 0 : res[i - 1][t - 1]) + getSum(sum, t, j) * 1.0 / (j - t + 1));
                }
                res[i][j] = max;
            }
        }
        return res[K][A.length - 1];
    }

    public static void main(String[] args) {
        LeetCode813 l = new LeetCode813();
        System.out.println(l.largestSumOfAverages(new int[] {1}, 1));
    }

}
