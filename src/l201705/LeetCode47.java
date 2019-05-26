
package l201705;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lanshan
 */
public class LeetCode47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Set<String> set = new HashSet<>();
        get(nums, 0, lists, set);
        return lists;
    }

    public void get(int[] nums, int index, List<List<Integer>> list, Set<String> set) {
        if (index == nums.length) {
            List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
            String s = collect.toString();
            if (!set.contains(s)) {
                set.add(s);
                list.add(collect);
            }
            return;
        }
        for (int i = index; i < nums.length; i++) {
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
            get(nums, index + 1, list, set);
            temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {
        LeetCode47 l = new LeetCode47();
        System.out.println(l.permuteUnique(new int[] {1, 1, 2}));
    }
}
