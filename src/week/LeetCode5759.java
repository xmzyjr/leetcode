package week;

/**
 * @author lanshan
 */
public class LeetCode5759 {

    /**
     * 输入：nums = [5,1,6]
     * 输出：28
     * 解释：[5,1,6] 共有 8 个子集：
     * - 空子集的异或总和是 0 。
     * - [5] 的异或总和为 5 。
     * - [1] 的异或总和为 1 。
     * - [6] 的异或总和为 6 。
     * - [5,1] 的异或总和为 5 XOR 1 = 4 。
     * - [5,6] 的异或总和为 5 XOR 6 = 3 。
     * - [1,6] 的异或总和为 1 XOR 6 = 7 。
     * - [5,1,6] 的异或总和为 5 XOR 1 XOR 6 = 2 。
     * 0 + 5 + 1 + 6 + 4 + 3 + 7 + 2 = 28
     */
    int sum;
    public int subsetXORSum(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        sum = 0;
        find(nums, 0, 0);
        return sum;
    }

    private void find(int[] nums, int index, int temp) {
        if (index == nums.length) {
            sum += temp;
            return;
        }
        find(nums, index + 1, temp);
        find(nums, index + 1, temp ^ nums[index]);
    }

    public static void main(String[] args) {
        LeetCode5759 l = new LeetCode5759();
        System.out.println(l.subsetXORSum(new int[] {5, 1, 6}));
    }
}
