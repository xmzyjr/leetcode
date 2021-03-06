
package l201905;

/**
 * @author lanshan
 */
public class LeetCode50 {

    /**
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
     * 示例 1:
     * 输入: 2.00000, 10
     * 输出: 1024.00000
     * 示例 2:
     * 输入: 2.10000, 3
     * 输出: 9.26100
     * 示例 3:
     * 输入: 2.00000, -2
     * 输出: 0.25000
     * 解释: 2-2 = 1/22 = 1/4 = 0.25
     */
    public double myPow(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                res *= x;
            }
            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }

    public static void main(String[] args) {
        LeetCode50 l = new LeetCode50();
        System.out.println(l.myPow(1, -2));
    }
}
