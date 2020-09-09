package feture.greedy.mid;

import java.util.*;

/**
 * @author lanshan
 */
public class LeetCode1282 {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        if (groupSizes == null || groupSizes.length == 0)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>(groupSizes.length);
        for (int i = 0; i < groupSizes.length; i++) {
            if (groupSizes[i] == 1) {
                res.add(Collections.singletonList(i));
                continue;
            }
            List<Integer> list = map.get(groupSizes[i]);
            if (list == null) {
                list = new ArrayList<>();
                list.add(i);
                map.put(groupSizes[i], list);
            } else {
                list.add(i);
                if (list.size() == groupSizes[i]) {
                    res.add(list);
                    map.put(groupSizes[i], null);
                }
            }
        }
        return res;
    }
}
