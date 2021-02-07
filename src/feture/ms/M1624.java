package feture.ms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lanshan
 */
public class M1624 {
    /**
     * 设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。
     *
     * 示例 1:
     *
     * 输入: nums = [5,6,5], target = 11
     * 输出: [[5,6]]
     * 示例 2:
     *
     * 输入: nums = [5,6,5,6], target = 11
     * 输出: [[5,6],[5,6]]
     * 提示：
     *
     * nums.length <= 100000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/pairs-with-sum-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<Integer>> pairSums(int[] nums, int target) {
        if (nums == null || nums.length <= 1)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>(nums.length / 2 + 1);
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int num = nums[left] + nums[right];
            if (num == target) {
                res.add(Arrays.asList(nums[left], nums[right]));
                left++;
                right--;
            } else if (num < target) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
