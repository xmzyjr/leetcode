
package feture.dp.mid;

/**
 * @author lanshan
 */
public class Work0811 {

    /**
     * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
     * 示例1:
     * 输入: n = 5
     * 输出：2
     * 解释: 有两种方式可以凑成总金额:
     * 5=5
     * 5=1+1+1+1+1
     * 示例2:
     * 输入: n = 10
     * 输出：4
     * 解释: 有四种方式可以凑成总金额:
     * 10=10
     * 10=5+5
     * 10=5+1+1+1+1+1
     * 10=1+1+1+1+1+1+1+1+1+1
     */
    private static final int mod = 1000000007;

    public int waysToChange2(int n) {
        if (n <= 0) {
            return 0;
        }
        return find(n, 25);
    }

    public int waysToChange(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = 1;
        }
        int[] num = new int[]{1,5,10,25};
        for (int i = 1; i < 4; i++) {
            for (int j = num[i]; j <= n; j++) {
                res[j] = (res[j - num[i]] + res[j]) % mod;
            }
        }
        return res[n];
    }

    private int find(int n, int index) {
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;
        if (index == 25) {
            return find(n - 25, 25) + find(n - 10, 10) + find(n - 5, 5) + find(n - 1, 1);
        } else if (index == 10) {
            return find(n - 10, 10) + find(n - 5, 5) + find(n - 1, 1);
        } else if (index == 5) {
            return find(n - 5, 5) + find(n - 1, 1);
        } else {
            return find(n - 1, 1);
        }
    }

    public static void main(String[] args) {
        Work0811 l = new Work0811();
        System.out.println(l.waysToChange(1000000));

    }
}
