
package feture.binary.search.easy;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class LeetCode475 {

    static class Solution {

        public int findRadius(int[] houses, int[] heaters) {
            Arrays.sort(heaters);
            int res = 0;
            for (int house : houses) {
                int left = 0, right = heaters.length - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (house > heaters[mid]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                int rightNum = left == heaters.length ? Integer.MAX_VALUE: heaters[left]-house;
                int leftNum = left == 0 ? Integer.MAX_VALUE: house-heaters[right];
                res = Math.max(res, Math.min(leftNum, rightNum));
            }
            return res;
        }

        public static void main(String[] args) {
            Solution l = new Solution();
            l.findRadius(new int[] { 1, 2, 3 }, new int[] { 2 });
        }
    }

}
