package feture.game.l0712;

/**
 * @author lanshan
 */
public class LeetCode5460 {
    class Solution {
        public int numIdenticalPairs(int[] nums) {
            if (nums == null || nums.length == 0)
                return 0;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[i] == nums[j]) {
                        count++;
                    }
                }
            }
            return count;
        }
    }
}
