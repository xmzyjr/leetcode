package feture.dp.easy;

/**
 * @author lanshan
 */
public class LeetCode303 {
    class NumArray {

        int[] res;

        public NumArray(int[] nums) {
            if (nums == null || nums.length == 0)
                return;
            res = new int[nums.length];
            res[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                res[i] = nums[i] + res[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            if (res == null)
                return 0;
            return i != 0 ? res[j] - res[i - 1] : res[j];
        }
    }
    
}
