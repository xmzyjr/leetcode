package feture.bd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lanshan
 */
public class LeetCode46 {

    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * 示例 2：
     *
     * 输入：nums = [0,1]
     * 输出：[[0,1],[1,0]]
     * 示例 3：
     *
     * 输入：nums = [1]
     * 输出：[[1]]
     *  
     *
     * 提示：
     *
     * 1 <= nums.length <= 6
     * -10 <= nums[i] <= 10
     * nums 中的所有整数 互不相同
     */
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        find(nums, 0);
        return res;
    }

    public void find(int[] nums, int index) {
        if (index == nums.length) {
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            find(nums, index + 1);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        LeetCode46 l = new LeetCode46();
        System.out.println(l.permute(new int[] {1, 2, 3}));
        System.out.println(l.permute(new int[] {1, 2}));
        System.out.println(l.permute(new int[] {1}));
        System.out.println(l.permute(new int[] { 1, 2, 3, 4 }));
    }
}
