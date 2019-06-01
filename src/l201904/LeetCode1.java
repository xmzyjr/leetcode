package l201904;

/**
 * @author lanshan
 */
public class LeetCode1 {

    /**
     * [2,7,11,15]
     * 9
     */
    public int[] twoSum(int[] nums, int target) {

        int i, j = 0;
        label:
        for (i = 0; i < nums.length; i++) {
            for (j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    break label;
                }
            }
        }
        return new int[]{i, j};
    }

    public static void main(String[] args) {
        LeetCode1 leetCode1 = new LeetCode1();
        int[] ints = leetCode1.twoSum(new int[]{2, 7, 11, 15}, 9);
    }
}
