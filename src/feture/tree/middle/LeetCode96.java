package feture.tree.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lanshan
 */
public class LeetCode96 {
    
    private Map<Integer, Integer> map;

    public int numTrees(int n) {
        map = new HashMap<>();
        map.put(0, 1);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 5);
        if (n<=3)
            return map.get(n);
        for (int i = 4; i <= n; i++) {
            map.put(i, find(i));
        }
        return map.get(n);
    }
    
    private int find(int n) {
        int left = n-1, right = 0;
        int sum = 0;
        while (left >= right) {
            if (left == right) {
                sum += map.get(left) * map.get(left);
            } else {
                sum += 2 * map.get(left) * map.get(right);
            }
            left--;
            right++;
        }
        return sum;
    }

    public static void main(String[] args) {
        LeetCode96 l = new LeetCode96();
        System.out.println(l.numTrees(5));
    }
}
