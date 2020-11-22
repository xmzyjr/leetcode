
package feture.game.l1122;

/**
 * @author lanshan
 */
public class LeetCode5607 {

    public int waysToMakeFair(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i - 2 >= 0)
                left[i] = nums[i] + left[i - 2];
            else
                left[i] = nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + 2 <= nums.length - 1)
                right[i] = nums[i] + right[i + 2];
            else
                right[i] = nums[i];
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int leftNum = i - 1 >= 0 ? left[i - 1] : 0;
            int rightNum = i + 2 <= nums.length - 1 ? right[i + 2] : 0;
            int target = leftNum + rightNum;
            res = ((sum - target - nums[i]) == target) ? res + 1 : res;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode5607 l = new LeetCode5607();
        System.out.println(l.waysToMakeFair(new int[] { 2, 1, 6, 4 }));
        System.out.println(l.waysToMakeFair(new int[] { 1, 1, 1 }));
        System.out.println(l.waysToMakeFair(new int[]{1,2,3}));
    }
}
