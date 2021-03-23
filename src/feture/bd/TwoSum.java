package feture.bd;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author lanshan
 */
public class TwoSum {
    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     *
     * 你可以按任意顺序返回答案。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * 示例 2：
     *
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     * 示例 3：
     *
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     *  
     *
     * 提示：
     *
     * 2 <= nums.length <= 103
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     * 只会存在一个有效答案
     */

    static class Node {
        int val;
        int index;

        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[0];
        int left = 0, right = nums.length - 1;
        List<Node> res = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            res.add(new Node(nums[i], i));
        }
        res.sort(Comparator.comparingInt(o -> o.val));
        while (left < right) {
            int temp = res.get(left).val + res.get(right).val;
            if (temp < target) {
                left ++;
            } else if (temp > target) {
                right--;
            } else {
                return new int[] {res.get(left).index, res.get(right).index};
            }
        }
        return new int[0];
    }
}
