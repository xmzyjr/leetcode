package feture.tree.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode1104 {
    class Solution {
        public List<Integer> pathInZigZagTree(int label) {
            List<Integer> result = new ArrayList<>();
            while (label>0) {
                result.add(0, label);
                label = label >> 1;
            }
            if (result.size() == 0)
                return result;
            
            for (int i = result.size() - 2; i > 0; i -= 2) {
                int temp = (1 << i + 1) + (1 << i) - result.get(i) - 1;
                result.set(i, temp);
            }
            return result;
        }
    }
}
