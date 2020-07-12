package feture.dp.easy;

/**
 * @author lanshan
 */
public class Offer42 {
    class Solution {
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0)
                return 0;
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                max = Math.max(sum, max);
                if (sum < 0) {
                    sum = 0;
                }
            }
            return max;
        }
    }

}
