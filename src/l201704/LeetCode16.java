package l201704;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class LeetCode16 {

    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target
     * 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
     * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
     */

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int re = 0;
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int i1 = i + 1;
                int i2 = nums.length - 1;
                while (i1 < i2) {
                    int sum = nums[i1] + nums[i2] + nums[i];
                    if (Math.abs(sum- target) < len) {
                        len = Math.abs(sum- target);
                        re = sum;
                    }
                    if (sum > target) {
                        while (i1 < i2 && nums[i2] == nums[i2 - 1]) {
                            i2--;
                        }
                        i2--;
                    } else if (sum < target) {
                        while (i1 < i2 && nums[i1] == nums[i1 + 1]) {
                            i1++;
                        }
                        i1++;
                    } else {
                        return re;
                    }
                }
            }
        }
        return re;
    }

    public static void main(String[] args) {
        LeetCode16 l = new LeetCode16();
        System.out.println(l.threeSumClosest(new int[] {-1, 2, 1, -4}, 1));

    }
}
