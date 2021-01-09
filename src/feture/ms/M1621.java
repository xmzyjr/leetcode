
package feture.ms;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class M1621 {

    /**
     * 给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
     * 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
     * 示例:
     * 输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
     * 输出: [1, 3]
     * 示例:
     * 输入: array1 = [1, 2, 3], array2 = [4, 5, 6]
     * 输出: []
     * 提示：
     * 1 <= array1.length, array2.length <= 100000
     */
    public int[] findSwapValues(int[] array1, int[] array2) {
        Arrays.sort(array1);
        Arrays.sort(array2);
        int index1 = 0, index2 = 0;
        int sum1 = getSum(array1);
        int sum2 = getSum(array2);
        if (Math.abs(sum1 - sum2) % 2 != 0) {
            return new int[0];
        }
        int target = (sum1 - sum2) / 2;
        while (index1 < array1.length && index2 < array2.length) {
            int temp = array1[index1] - array2[index2];
            if (temp == target) {
                return new int[] {array1[index1], array2[index2]};
            } else if (temp < target){
                index1++;
            } else {
                index2++;
            }
        }
        return new int[0];
    }

    private int getSum(int[] num) {
        int sum = 0;
        for (int i : num) {
            sum += i;
        }
        return sum;
    }

    /**
     * [519, 886, 282, 382, 662, 4718, 258, 719, 494, 795]
     * [52, 20, 78, 50, 38, 96, 81, 20]
     */
    public static void main(String[] args) {
        M1621 m = new M1621();
        System.out.println(Arrays.toString(m.findSwapValues(new int[] {519, 886, 282, 382, 662, 4718, 258, 719, 494, 795},
                new int[] {52, 20, 78, 50, 38, 96, 81, 20})));
    }
}
