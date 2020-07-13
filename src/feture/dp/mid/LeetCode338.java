package feture.dp.mid;

/**
 * @author lanshan
 */
public class LeetCode338 {
    class Solution {

        public int[] countBits(int num) {
            if (num<0)
                return new int[0];
            if (num == 0) {
                return new int[] { num };
            }
            if (num == 1) {
                return new int[] { 0, 1 };
            }
            int[] nums = new int[num+1];
            nums[0] = 0;
            nums[1] = 1;
            int flag = 1;
            int count = 1;
            boolean left = true;
            for (int i = 2; i < nums.length; i++) {
                nums[i] = left ? nums[i - flag] : nums[i - flag] + 1;
                count--;
                if (count == 0) {
                    left = !left;
                    if (left) {
                        flag = (flag << 1);
                    }
                    count = flag;
                }
            }
            return nums;
        }
    }
}
