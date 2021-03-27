package feture.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lanshan
 */
public class Offer03 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> num = new HashSet<>(nums.length / 2);
        for (int i : nums) {
            if (num.contains(i)) {
                return i;
            }
            num.add(i);
        }
        return 0;
    }
}
