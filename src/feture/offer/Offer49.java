package feture.offer;

/**
 * @author lanshan
 */
public class Offer49 {

    /**
     * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
     *
     *  
     *
     * 示例:
     *
     * 输入: n = 10
     * 输出: 12
     * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
     * 说明:
     *
     * 1 是丑数。
     * n 不超过1690。
     */
    public int nthUglyNumber(int n) {
        if (n == 1)
            return 1;
        int[] num = new int[n];
        num[0] = 1;
        int index1 = 0, index2 = 0, index3 = 0;
        for (int i = 1; i < num.length; i++) {
            num[i] = getMin(num[index1], num[index2], num[index3]);
            while (num[index1] * 2 <= num[i])
                index1++;
            while (num[index2] * 3 <= num[i])
                index2++;
            while (num[index3] * 5 <= num[i])
                index3++;
        }
        return num[n - 1];
    }

    private int getMin(int i, int j, int k) {
        return Math.min(i, Math.min(j, k));
    }
}
