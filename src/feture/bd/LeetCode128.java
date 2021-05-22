package feture.bd;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lanshan
 */
public class LeetCode128 {
    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     *
     *  
     *
     * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     * 示例 2：
     *
     * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
     * 输出：9
     *  
     *
     * 提示：
     *
     * 0 <= nums.length <= 104
     * -109 <= nums[i] <= 109
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int count = 1;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int c = 1;
                int temp = num;
                while (set.contains(temp + 1)) {
                    c++;
                    temp++;
                }
                count = Math.max(count, c);
            }
        }
        return count;
    }
}
