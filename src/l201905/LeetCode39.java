
package l201905;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> num = new ArrayList<>();
        Arrays.sort(candidates);
        get(candidates, target, num, new ArrayList<>(), 0, 0);
        return num;
    }

    public void get(int[] candidates, int target, List<List<Integer>> num, List<Integer> list, int now, int index) {
        if (now > target) {
            return;
        }
        if (now == target && list != null) {
            num.add(list);
        }
        for (int i = index; i < candidates.length; i++) {
            ArrayList<Integer> num1 = new ArrayList<>(list);
            num1.add(candidates[i]);
            get(candidates, target, num, num1, now + candidates[i], i);
        }
    }

    public static void main(String[] args) {
        LeetCode39 l = new LeetCode39();
        System.out.println(l.combinationSum(new int[] {2, 3, 5}, 8));
    }
}
