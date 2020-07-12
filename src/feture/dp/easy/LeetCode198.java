package feture.dp.easy;

/**
 * @author lanshan
 */
public class LeetCode198 {
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0)
                return 0;
            for (int i = nums.length - 2; i >= 0; i--) {
                if (i == nums.length -2) {
                    nums[i] = Math.max(nums[i], nums[i+1]);
                } else {
                    nums[i] = Math.max(nums[i]+nums[i+2], nums[i+1]);
                }
            }
            return nums[0];
        }
    }
}
