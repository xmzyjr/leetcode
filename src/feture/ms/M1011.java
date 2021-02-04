package feture.ms;

import feture.util.LeetCodeUtil;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class M1011 {
    /**
     * 在一个整数数组中，“峰”是大于或等于相邻整数的元素，相应地，“谷”是小于或等于相邻整数的元素。
     * 例如，在数组{5, 8, 4, 2, 3, 4, 6}中，{8, 6}是峰， {5, 2}是谷。现在给定一个整数数组，将该数组按峰与谷的交替顺序排序。
     *
     * 示例:
     *
     * 输入: [5, 3, 1, 2, 3]
     * 输出: [5, 1, 3, 2, 3]
     * 提示：
     *
     * nums.length <= 10000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/peaks-and-valleys-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 2)
            return;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i+=2) {
            int temp = nums[i];
            nums[i] = nums[i-1];
            nums[i-1] = temp;
        }
    }

    public static void main(String[] args) {
        M1011 m = new M1011();
        m.wiggleSort(new int[]{1,2,3,4,5,6,7});
    }
}
