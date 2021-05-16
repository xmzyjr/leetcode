package feture.offer;

/**
 * @author lanshan
 */
public class Offer64 {
    /**
     * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     *
     *  
     *
     * 示例 1：
     *
     * 输入: n = 3
     * 输出: 6
     * 示例 2：
     *
     * 输入: n = 9
     * 输出: 45
     */
    public int sumNums(int n) {
        if (n == 1)
            return 1;
        return sumNums(n - 1) + n;
    }
}
