
package l201705;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lanshan
 */
public class LeetCode45 {

    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * 示例:
     * 输入: [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     */

    public int jump1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 0;
        }
        int[] mem = new int[nums.length];
        mem[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                mem[i] = Integer.MAX_VALUE - 1;
            } else {
                int min = Integer.MAX_VALUE - 1;
                for (int j = nums[i]; j > 0; j--) {
                    if (i + j >= nums.length - 1) {
                        min = 0;
                        break;
                    } else {
                        min = Math.min(min, mem[i + j]);
                    }
                }
                mem[i] = min + 1;
            }
        }
        return mem[0];
    }

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int step = 0;
        int max = 0;
        int stepCount = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(i + nums[i], max);
            if (max > nums.length - 1) {
                return step + 1;
            }
            if (i == stepCount) {
                step++;
                stepCount = max;
            }
        }
        return step;
    }

    /**
     * [5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5]
     * [2,3,0,1,4]
     * [5,9,3,2,1,0,2,3,3,1,0,0]
     */
    public static void main(String[] args) {
        LeetCode45 l = new LeetCode45();
        System.out.println(l.jump1(new int[] { 5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7,
                9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5 }));
    }
}
