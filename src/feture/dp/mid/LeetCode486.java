package feture.dp.mid;

import feture.util.LeetCodeUtil;

/**
 * @author lanshan
 */
public class LeetCode486 {
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        if (nums.length == 1)
            return true;
        int sum = 0;
        for (int num : nums) {
            sum +=num;
        }
        int[][] one = new int[nums.length][nums.length];
        int[][] two = new int[nums.length][nums.length];

        for (int i = one.length - 1; i >= 0; i--) {
            for (int j = i; j < one.length; j++) {
                if (i==j) {
                    one[i][j] = nums[i];
                    two[i][j] = 0;
                } else {
                    one[i][j] = Math.max(two[i+1][j]+nums[i], two[i][j-1]+nums[j]);
                    two[i][j] = Math.min(one[i + 1][j], one[i][j - 1]);
                }
            }
        }
        LeetCodeUtil.print(one);
        LeetCodeUtil.print(two);

        int first = one[0][nums.length-1];
        return first >= sum - first;
    }

    public static void main(String[] args) {
        LeetCode486 l = new LeetCode486();
        l.PredictTheWinner(new int[]{1,5,233,7});
    }
    
    private int first(int[] nums, int i, int j) {
        if (i == j) {
            return nums[i];
        }
        return Math.max(second(nums, i + 1, j) + nums[i], second(nums, i, j - 1) + nums[j]);
    }
    
    private int second(int[] nums, int i, int j) {
        if (i == j)
            return 0;
        return Math.min(first(nums, i + 1, j), first(nums, i, j - 1));
    }
}
