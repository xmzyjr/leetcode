
package l201906;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode77 {

    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     * 示例:
     * 输入: n = 4, k = 2
     * 输出:
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        get(list, n, k, 1, new ArrayList<>());
        return list;
    }

    public void get(List<List<Integer>> list, int n, int k, int index, List<Integer> need) {
        if (need.size() == k) {
            List<Integer> list1 = new ArrayList<>(need);
            list.add(list1);
            return;
        }
        for (int i = index; i <= n; i++) {
            need.add(i);
            int size = need.size();
            get(list, n, k, i + 1, need);
            need.remove(size - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode77 l = new LeetCode77();
        System.out.println(l.combine(4, 2));
    }
}
