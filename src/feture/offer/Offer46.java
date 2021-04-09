package feture.offer;

/**
 * @author lanshan
 */
public class Offer46 {
    /**
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
     * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: 12258
     * 输出: 5
     * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
     */
    public int translateNum(int num) {
        if (num < 0) {
            return 0;
        }
        int i1 = 0, i2 = -1;
        int post = -1;
        int count = 1;
        int now;
        while (num != 0) {
            now = num % 10;
            if (post == -1) {
                count = 1;
                i1 = 1;
            } else {
                if (now == 1 || (now == 2 && post <= 5)) {
                    count = i2 == -1 ? 2 : i1 + i2;
                    i2 = i1;
                    i1 = count;
                } else {
                    count = i1;
                    i2 = i1;
                }
            }
            post = now;
            num /= 10;
        }
        return count;
    }
}
