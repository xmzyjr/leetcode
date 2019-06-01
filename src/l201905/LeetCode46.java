
package l201905;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lanshan
 */
public class LeetCode46 {

    /**
     * 给定一个没有重复数字的序列，返回其所有可能的全排列。
     * 示例:
     * 输入: [1,2,3]
     * 输出:
     * [
     * [1,2,3],
     * [1,3,2],
     * [2,1,3],
     * [2,3,1],
     * [3,1,2],
     * [3,2,1]
     * ]
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        get(nums, 0, lists);
        return lists;
    }

    public void get(int[] nums, int index, List<List<Integer>> list) {
        if (index == nums.length) {
            List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
            list.add(collect);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
            get(nums, index + 1, list);
            temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {
        LeetCode46 l = new LeetCode46();
        System.out.println(l.permute(new int[] { 1, 2, 3 }));
    }
}
