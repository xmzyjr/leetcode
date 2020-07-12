package feture.dp.easy;

/**
 * @author lanshan
 */
public class Work1716 {
    static class Solution {
        public int massage(int[] nums) {
            if (nums == null|| nums.length == 0)
                return 0;
            return find(nums, 0, 0);
        }

        private int find(int[] nums, int index, int sum) {
            if (index >= nums.length) {
                return sum;
            }
            return Math.max(find(nums, index + 2, sum + nums[index]), find(nums, index + 1, sum));
        }

        public int massage2(int[] nums) {
            if (nums == null|| nums.length == 0)
                return 0;
            if (nums.length == 1)
                return nums[0];
            for (int i = nums.length - 2; i >= 0; i--) {
                if (i == nums.length-2) {
                    nums[i] = Math.max(nums[i], nums[i+1]);
                } else {
                    nums[i] = Math.max(nums[i] + nums[i + 2], nums[i + 1]);
                }
            }
            return nums[0];
        }

        public static void main(String[] args) {
            Solution s = new Solution();
            System.out.println(s.massage(new int[] {4, 1, 2, 7, 5, 3, 1}));
        }
    }
}
