package feture.greedy.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode1403 {

    public List<Integer> minSubsequence(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();
        if (nums.length == 1)
            return Collections.singletonList(nums[0]);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        double half = sum * 1.0 / 2;
        Arrays.sort(nums);
        sum = 0;
        List<Integer> list = new ArrayList<>(nums.length / 2 + 1);
        for (int i = nums.length-1; i >= 0; i--) {
            int num = nums[i];
            sum += num;
            list.add(num);
            if (sum >= half) {
                break;
            }
        }
        return list;
    }
}
