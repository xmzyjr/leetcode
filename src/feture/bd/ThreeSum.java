package feture.bd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lanshan
 */
public class ThreeSum {
    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 示例 2：
     *
     * 输入：nums = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：nums = [0]
     * 输出：[]
     *  
     *
     * 提示：
     *
     * 0 <= nums.length <= 3000
     * -105 <= nums[i] <= 105
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length <= 2)
            return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1])
                continue;
            int right = nums.length - 1;
            for (int second = first + 1; second < nums.length - 1; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1])
                    continue;
                while (right > second && nums[right] + nums[second] > -nums[first]) {
                    right--;
                }
                if (right <= second)
                    break;
                if (nums[right] + nums[second] + nums[first] == 0) {
                    res.add(Arrays.asList(nums[first], nums[second], nums[right]));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        System.out.println(t.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
    }
}
