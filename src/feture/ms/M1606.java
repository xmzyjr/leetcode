package feture.ms;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class M1606 {
    /**
     * 给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
     *
     *  
     *
     * 示例：
     *
     * 输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
     * 输出：3，即数值对(11, 8)
     *  
     *
     * 提示：
     *
     * 1 <= a.length, b.length <= 100000
     * -2147483648 <= a[i], b[i] <= 2147483647
     * 正确结果在区间 [0, 2147483647] 内
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/smallest-difference-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        long min = Math.abs((long) (a[0]-b[0]));
        int index1 = 0, index2 = 0;
        while (index1 < a.length && index2 < b.length) {
            min = Math.min(min, Math.abs((long) (a[index1] - b[index2])));
            if (a[index1] < b[index2]) {
                index1++;
            } else {
                index2++;
            }
        }
        return (int) min;
    }

    /**
     * [-2147483648,1]
     * [2147483647,0]
     */
    public static void main(String[] args) {
        M1606 m = new M1606();
        System.out.println(m.smallestDifference(new int[] {-2147483648, 1}, new int[] {2147483647, 0}));
    }
}
