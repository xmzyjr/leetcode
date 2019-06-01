package l201904;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode15 {

    /**
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
     * ？找出所有满足条件且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     * 满足要求的三元组集合为：
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if(i==0 || (i>0&&nums[i]!=nums[i-1])) {
                int i1 = i + 1;
                int i2 = nums.length - 1;
                while (i1 < i2) {
                    if (nums[i1] + nums[i2] > (-nums[i])) {
                        while(i1<i2 && nums[i2]==nums[i2-1]) {
                            i2--;
                        }
                        i2--;
                    } else if (nums[i1] + nums[i2] < (-nums[i])) {
                        while(i1<i2 && nums[i1]==nums[i1+1]) {
                            i1++;
                        }
                        i1++;
                    } else {
                        list.add(Arrays.asList(nums[i],nums[i1],nums[i2]));
                        while(i1<i2 && nums[i2]==nums[i2-1]) i2--;
                        while(i1<i2 && nums[i1]==nums[i1+1]) i1++;
                        i1++;
                        i2--;
                    }
                }
            }

        }
        return list;
    }

    public static void main(String[] args) {
        LeetCode15 l = new LeetCode15();
        System.out.println(l.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
    }
}
