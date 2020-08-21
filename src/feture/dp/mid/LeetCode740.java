package feture.dp.mid;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author lanshan
 */
public class LeetCode740 {
    
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        SortedSet<Integer> indexes = new TreeSet<>();
        int[] target = new int[10001];
        for (int num : nums) {
            target[num]+=num;
            indexes.add(num);
        }
        System.out.println(Arrays.toString(target));
        Integer[] nums2 = indexes.toArray(new Integer[0]);
        System.out.println(Arrays.toString(nums2));
        int[] res = new int[nums2.length];
        res[nums2.length-1]= target[nums2[nums2.length-1]];
        for (int i = nums2.length - 2; i >= 0; i--) {
            if (nums2[i]+1 == nums2[i+1]) {
                res[i] = Math.max(res[i + 1],
                        i + 2 < nums2.length ? (target[nums2[i]] + res[i + 2]) : target[nums2[i]]);
            } else {
                res[i] = res[i + 1] + target[nums2[i]];
            }
        }
        System.out.println(Arrays.toString(res));
        return res[0];
    }

    public static void main(String[] args) {
        LeetCode740 l = new LeetCode740();
        System.out.println(l.deleteAndEarn(new int[] {2, 2, 3, 3, 3, 4}));

    }
}
