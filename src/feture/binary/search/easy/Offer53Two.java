package feture.binary.search.easy;

/**
 * @author lanshan
 */
public class Offer53Two {
    class Solution {
        public int missingNumber(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left<=right) {
                int mid = left + (right - left)/2;
                if (mid == nums[mid]) {
                    left = mid +1;
                } else if (mid < nums[mid]) {
                    right = mid - 1;
                }
            }
            return left;
        }
    }
}
