
package feture.binary.search.easy;

/**
 * @author lanshan
 */
public class Offer53 {

    class Solution {

        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0)
                return 0;
            int left = find(nums, target, true);
            if (left == -1) {
                return 0;
            }
            int right = find(nums, target, false);
            return right - left + 1;
        }

        public int find(int[] nums, int target, boolean isLeft) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    if (isLeft)
                        right = mid - 1;
                    else 
                        left = mid + 1;
                }else if (nums[mid] < target) {
                    left = mid +1;
                } else if (nums[mid]>target) {
                    right = mid - 1;
                }
            }
            if (isLeft) {
                // left >= nums.length 说明 target 比数组里面的都要大
                // nums[left]!=target 说明，left = 0，right = -1，target 比数组里面的都要小
                if (left>=nums.length || nums[left]!= target)
                    return -1;
                return left;
            } else {
                if (right<0 || nums[right]!=target)
                    return -1;
                return right;
            }
        }
    }
}
