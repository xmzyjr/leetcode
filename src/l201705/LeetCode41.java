
package l201705;

/**
 * @author lanshan
 */
public class LeetCode41 {

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 1 && nums[i] < nums.length && nums[i] != i + 1) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    /**
     * [-1,4,2,1,9,10]
     */
    public static void main(String[] args) {
        LeetCode41 l = new LeetCode41();
        System.out.println(l.firstMissingPositive(new int[] {-1, 4, 2, 1, 9, 10}));
    }
}
