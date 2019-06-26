
package l201906;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode78 {

    /**
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * 说明：解集不能包含重复的子集。
     * 示例:
     * 输入: nums = [1,2,3]
     * 输出:
     * [
     * [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        get(list, nums, new ArrayList<>(), 0);
        return list;
    }

    public void get(List<List<Integer>> list, int[] nums, List<Integer> num, int index) {
        if (index == nums.length) {
            list.add(new ArrayList<>(num));
            return;
        }
        get(list, nums, new ArrayList<>(num), index + 1);
        num.add(nums[index]);
        get(list, nums, new ArrayList<>(num), index + 1);
    }

    public static void main(String[] args) {
        LeetCode78 l = new LeetCode78();
        System.out.println(l.subsets(new int[] {1, 2, 3}));
    }
}
