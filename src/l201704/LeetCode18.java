package l201704;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (j == 0 || nums[j] != nums[j - 1]) {
                for (int i = j + 1; i < nums.length; i++) {
                    if (i == j + 1 || nums[i] != nums[i - 1]) {
                        int i1 = i + 1;
                        int i2 = nums.length - 1;
                        while (i1 < i2) {
                            if (nums[i1] + nums[i2] + nums[i] + nums[j] > target) {
                                while (i1 < i2 && nums[i2] == nums[i2 - 1]) {
                                    i2--;
                                }
                                i2--;
                            } else if (nums[i1] + nums[i2] + nums[i] + nums[j] < target) {
                                while (i1 < i2 && nums[i1] == nums[i1 + 1]) {
                                    i1++;
                                }
                                i1++;
                            } else {
                                list.add(Arrays.asList(nums[j], nums[i], nums[i1], nums[i2]));
                                while (i1 < i2 && nums[i2] == nums[i2 - 1])
                                    i2--;
                                while (i1 < i2 && nums[i1] == nums[i1 + 1])
                                    i1++;
                                i1++;
                                i2--;
                            }
                        }
                    }
                }
            }

        }
        return list;
    }

    /**
     * [-1,0,1,2,-1,-4]
     * -4,-1,-1,0,1,2
     * [[-4,0,1,2]]
     * [[-4,0,1,2],[-1,-1,0,1]]
     * -1
     * [-3,-2,-1,0,0,1,2,3]
     * 0
     * [[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     */
    public static void main(String[] args) {
        LeetCode18 l = new LeetCode18();
        System.out.println(l.fourSum(new int[] { -1, 0, 1, 2, -1, -4 }, -1));

    }
}
