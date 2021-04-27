package feture.dp.hard;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class LeetCode312 {

    /**
     * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组nums中。
     *
     * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。
     * 这里的 i - 1 和 i + 1 代表和i相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
     *
     * 求所能获得硬币的最大数量。
     *
     * 示例 1：
     * 输入：nums = [3,1,5,8]
     * 输出：167
     * 解释：
     * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
     * coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
     * 示例 2：
     *
     * 输入：nums = [1,5]
     * 输出：10
     *
     * 提示：
     *
     * n == nums.length
     * 1 <= n <= 500
     * 0 <= nums[i] <= 100
     */
    int[][] res;
    int[] temp;
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        res = new int[nums.length + 2][nums.length + 2];
        temp = new int[nums.length + 2];
        for (int[] re : res) {
            Arrays.fill(re, -1);
        }
        temp[0] = 1;
        temp[temp.length - 1] = 1;
        System.arraycopy(nums, 0, temp, 1, nums.length);
        return find(0, nums.length + 1);
    }

    private int find( int left, int right) {
        if (left >= right - 1)
            return 0;
        if (res[left][right] != -1)
            return res[left][right];
        for (int i = left + 1; i < right; i++) {
            int sum = temp[left] * temp[i] * temp[right];
            sum += find(left, i) + find(i, right);
            res[left][right] = Math.max(res[left][right], sum);
        }
        return res[left][right];
    }

    public static void main(String[] args) {
        LeetCode312 l = new LeetCode312();
        l.maxCoins(new int[] {1, 2});
    }
}
