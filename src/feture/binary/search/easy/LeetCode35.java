
package feture.binary.search.easy;

/**
 * @author lanshan
 */
public class LeetCode35 {

    class Solution {

        public int searchInsert(int[] nums, int target) {
            if (nums == null || nums.length == 0)
                return 0;
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left)/2;
                if (nums[mid] == target) {
                    right = mid - 1;
                } else if (nums[mid]>target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
