package feture.ms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class M0804 {
    /**
     * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
     *
     * 说明：解集不能包含重复的子集。
     *
     * 示例:
     *
     *  输入： nums = [1,2,3]
     *  输出：
     * [
     *   [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/power-set-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        find(nums, new ArrayList<>(), 0);
        return res;
    }

    private void find(int[] nums, List<Integer> temp, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        find(nums, temp, index+1);
        temp.remove(temp.size() - 1);
        find(nums, temp, index+1);
    }

    public static void main(String[] args) {
        M0804 m = new M0804();
        System.out.println(m.subsets(new int[] {1, 2, 3}));
    }

}
