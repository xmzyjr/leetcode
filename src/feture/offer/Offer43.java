package feture.offer;

/**
 * @author lanshan
 */
public class Offer43 {
    /**
     * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
     *
     * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：n = 12
     * 输出：5
     * 示例 2：
     *
     * 输入：n = 13
     * 输出：6
     *  
     *
     * 限制：
     *
     * 1 <= n < 2^31
     */
    public int countDigitOne(int n) {
        int high = n;
        int cur = 0;
        int low = 0;
        int num = 1;
        int count = 0;
        while (high != 0 || cur != 0) {
            cur = high % 10;
            high = high / 10;
            if (cur == 0)
                count += high * num;
            else if (cur == 1)
                count += high * num + low + 1;
            else
                count += high * num + num;
            low += cur * num;
            num *= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        Offer43 o = new Offer43();
        System.out.println(o.countDigitOne(999));
    }
}
