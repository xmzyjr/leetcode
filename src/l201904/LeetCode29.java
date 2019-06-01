
package l201904;

/**
 * @author lanshan
 */
public class LeetCode29 {

    /**
     * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
     * 返回被除数 dividend 除以除数 divisor 得到的商。
     * 示例 1:
     * 输入: dividend = 10, divisor = 3
     * 输出: 3
     * 示例 2:
     * 输入: dividend = 7, divisor = -3
     * 输出: -2
     * 说明:
     * 被除数和除数均为 32 位有符号整数。
     * 除数不为 0。
     * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
     * 100/3 = 33
     * dividend = 100 divisor = 3
     */
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if(dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }

        boolean n = (dividend ^ divisor) < 0;
        int result = 0;
        long dividend1 = Math.abs(dividend);
        long divisor1 = Math.abs(divisor);
        for (int i = 31; i >= 0; i--) {
            if ((dividend1 >> i) >= divisor1) {
                dividend1 -= divisor1 << i;
                result += 1 << i;
            }
        }
        return n ? -result : result;
    }

    public static void main(String[] args) {
        LeetCode29 l = new LeetCode29();
        System.out.println(l.divide(100, 3));
    }
}
