package feture.dp.mid;

/**
 * @author lanshan
 */
public class LeetCode1262 {

    public int maxSumDivThree(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[][] res = new int[nums.length + 1][3];
        res[0][0] = 0;
        res[0][1] = Integer.MIN_VALUE;
        res[0][2] = Integer.MIN_VALUE;

        for (int i = 1; i <= nums.length; i++) {
            if (nums[i-1] % 3 == 0) {
                res[i][0] = Math.max(res[i - 1][0], res[i - 1][0] + nums[i - 1]);
                res[i][1] = Math.max(res[i - 1][1], res[i - 1][1] + nums[i - 1]);
                res[i][2] = Math.max(res[i - 1][2], res[i - 1][2] + nums[i - 1]);
            } else if (nums[i-1]%3 == 1) {
                res[i][0] = Math.max(res[i - 1][0], res[i - 1][2] + nums[i - 1]);
                res[i][1] = Math.max(res[i - 1][1], res[i - 1][0] + nums[i - 1]);
                res[i][2] = Math.max(res[i - 1][2], res[i - 1][1] + nums[i - 1]);
            } else {
                res[i][0] = Math.max(res[i - 1][0], res[i - 1][1] + nums[i - 1]);
                res[i][1] = Math.max(res[i - 1][1], res[i - 1][2] + nums[i - 1]);
                res[i][2] = Math.max(res[i - 1][2], res[i - 1][0] + nums[i - 1]);
            }
        }

        return res[nums.length][0];
    }
}
