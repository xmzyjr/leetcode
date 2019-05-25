
package l201705;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            label: for (List<Integer> integers : num) {
                if (integers.size() == list.size()) {
                    int i;
                    for (i = 0; i < integers.size(); i++) {
                        if (!integers.get(i).equals(list.get(i))) {
                            continue label;
                        }
                    }
                    if (i == integers.size()) {
                        return;
                    }
                }
            }
            num.add(list);
        }
        for (int i = index; i < candidates.length; i++) {
            ArrayList<Integer> num1 = new ArrayList<>(list);
            if (now == target || now + candidates[i] > target) {
                break;
            }
            num1.add(candidates[i]);
            get(candidates, target, num, num1, now + candidates[i], i + 1);
        }
    }

    /**
     * [4,4,2,1,4,2,2,1,3]
     * 6
     */
    public static void main(String[] args) {
        LeetCode40 l = new LeetCode40();
        System.out.println(l.combinationSum2(new int[] { 4, 4, 2, 1, 4, 2, 2, 1, 3 }, 6));
    }
}
