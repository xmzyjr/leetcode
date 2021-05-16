package feture.offer;

/**
 * @author lanshan
 */
public class Offer65 {
    /**
     * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
     *
     *  
     *
     * 示例:
     *
     * 输入: a = 1, b = 1
     * 输出: 2
     *  
     *
     * 提示：
     *
     * a, b 均可能是负数或 0
     * 结果不会溢出 32 位整数
     */
    public int add(int a, int b) {
        int temp = a ^ b;
        int add = (a & b) << 1;
        while (add != 0) {
            int t = temp;
            temp ^= add;
            add = (add & t) << 1;
        }
        return temp;
    }

    int add3(int a, int b) {
        // 后续用a表示非进位和，b表示进位，当进位为0，则表示计算结束
        return b == 0 ? a : add3(a^b, (a&b) << 1);
    }

    public int add2(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }

    public static void main(String[] args) {
        Offer65 o = new Offer65();
        System.out.println(o.add(111, 899));
        System.out.println(o.add2(111, 899));
        System.out.println(o.add3(111, 899));
    }

}
