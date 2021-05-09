package feture.offer;

/**
 * @author lanshan
 */
public class Offer44 {
    /**
     * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
     *
     * 请写一个函数，求任意第n位对应的数字。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：n = 3
     * 输出：3
     * 示例 2：
     *
     * 输入：n = 11
     * 输出：0
     */
    public int findNthDigit(int n) {
        int start = 1;
        int numCount = 1;
        long index = 10;
        long count = 9;
        while (n > count) {
            n -= count;
            start = (int) index;
            numCount++;
            index *= 10;
            count = numCount * (index - start);
        }
        int num = start + ((n - 1) / numCount);
        String str = String.valueOf(num);
        return str.charAt((n - 1) % numCount) - '0';
    }

    public int findNthDigit2(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        int i = (n - 1) % digit;
        return Long.toString(num).charAt(i) - '0'; // 3.
    }

    public static void main(String[] args) {
        Offer44 o = new Offer44();
        System.out.println(o.findNthDigit2(1000000000));
        System.out.println(o.findNthDigit(1000000000));
        System.out.println(o.findNthDigit(3));
        System.out.println(o.findNthDigit(11));
        System.out.println(o.findNthDigit(10));
        System.out.println(o.findNthDigit(1000));
    }
    
}
