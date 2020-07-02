package feture.binary.search.easy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author lanshan
 */
public class LeetCode349 {
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            HashSet<Integer> set =  new HashSet<>(Math.max(nums1.length, nums2.length));
            for (int i : nums1) {
                set.add(i);
            }
            Set<Integer> res = new HashSet<>();
            for (int i : nums2) {
                if (set.contains(i)) {
                    res.add(i);
                }
            }
            if (res.size() == 0)
                return new int[0];
            int[] num = new int[res.size()];
            Iterator<Integer> iterator = res.iterator();
            int index = 0;
            while (iterator.hasNext()) {
                num[index++] = iterator.next();
            }
            return num;
        }
    }
}
