package week;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lanshan
 */
public class LeetCode5761 {
    static class FindSumPairs {

        int[] t1, t2;
        public FindSumPairs(int[] nums1, int[] nums2) {
            t1 = nums1;
            Arrays.sort(t1);
            t2 = nums2;
        }

        public void add(int index, int val) {
            t2[index] += val;
        }

        public int count(int tot) {
            Map<Integer, Integer> map = new HashMap<>();
            int[] t = t1;
            int count = 0;
            int[] tempArray = t2;
            for (int j : tempArray) {
                int target = tot - j;
                if (target > t[t.length - 1] || target < t[0])
                    continue;
                Integer i = map.get(target);
                if (i != null) {
                    count += i;
                    continue;
                }
                int left = search(t, target, true);
                if (left < 0) {
                    map.put(target, 0);
                    continue;
                }
                int right = search(t, target, false);
                int temp = right - left + 1;
                map.put(target, temp);
                count += temp;
            }
            return count;
        }

        private int search(int[] t, int tot, boolean left) {
            int l = 0, r = t.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                int midVal = t[mid];
                if (midVal < tot)
                    l = mid + 1;
                else if (midVal > tot)
                    r = mid - 1;
                else {
                    if (left) {
                        if (mid - 1 >= 0 && t[mid - 1] == tot) {
                            r = mid - 1;
                        } else {
                            return mid;
                        }
                    } else {
                        if (mid + 1 < t.length && t[mid + 1] == tot) {
                            l = mid + 1;
                        } else {
                            return mid;
                        }
                    }
                }
            }
            return -1;
        }

        public static void main(String[] args) {
            FindSumPairs l = new FindSumPairs(new int[]{1, 1, 2, 2, 2, 3}, new int[]{1, 4, 5, 2, 5, 4});
            System.out.println(l.count(7));
        }
    }
}
