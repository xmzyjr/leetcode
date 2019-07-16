
package l201907;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode90 {

    /**
     * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * 说明：解集不能包含重复的子集。
     * 示例:
     * 输入: [1,2,2]
     * 输出:
     * [
     * [2],
     * [1],
     * [1,2,2],
     * [2,2],
     * [1,2],
     * []
     * ]
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        get(res, 0, nums, new ArrayList<>());
        return res;
    }

    public void get(List<List<Integer>> res, int index, int[] nums, List<Integer> list) {
        if (index == nums.length) {
            if (!check(res, list)) {
                res.add(list);
            }
            return;
        }
        get(res, index + 1, nums, new ArrayList<>(list));
        list.add(nums[index]);
        get(res, index + 1, nums, new ArrayList<>(list));
    }

    public boolean check(List<List<Integer>> res, List<Integer> list) {
        final boolean[] ck = {false};
        res.parallelStream().forEach(i -> {
            if (i.size() == list.size()) {
                int i1 = 0;
                for (i1 = 0; i1 < list.size(); i1++) {
                    if (!i.get(i1).equals(list.get(i1))) {
                        break;
                    }
                }
                if (i1 == list.size()) {
                    ck[0] = true;
                }
            }
        });
        return ck[0];
    }

    public static void main(String[] args) {
        LeetCode90 l = new LeetCode90();
        System.out.println(l.subsetsWithDup(new int[] {1, 2, 2}));
    }
}
