
package feture.binary.search.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lanshan
 */
public class LeetCode350 {

    class Solution {

        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                int[] temp = nums1;
                nums1 = nums2;
                nums2 = temp;
            }
            Map<Integer, Integer> map = new HashMap<>(nums2.length);
            for (int value : nums2) {
                Integer count = map.get(value);
                if (count == null) {
                    map.put(value, 1);
                } else {
                    map.put(value, ++count);
                }
            }
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < nums1.length; i++) {
                if (map.containsKey(nums1[i])) {
                    Integer count = map.get(nums1[i]);
                    if (count > 0) {
                        res.add(nums1[i]);
                        map.put(nums1[i], --count);
                    }
                }
            }
            int[] num = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                num[i] = res.get(i);
            }
            return num;
        }
    }
}
