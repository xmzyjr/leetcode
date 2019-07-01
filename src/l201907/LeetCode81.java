
package l201907;

/**
 * @author lanshan
 */
public class LeetCode81 {

    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
     * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
     * 示例 1:
     * 输入: nums = [2,5,6,0,0,1,2], target = 0
     * 输出: true
     * 示例 2:
     * 输入: nums = [2,5,6,0,0,1,2], target = 3
     * 输出: false
     */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0, right = nums.length - 1;
        boolean result = false;
        while (nums[left] != target && nums[right] != target && left < right) {
            while (left < right && nums[left] == nums[right] && nums[left] != target) {
                left++;
                right--;
            }
            if (nums[left] == target || nums[right] == target || left >= right) {
                break;
            }
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                result = true;
                break;
            }
            // 右段
            if (nums[mid] >= nums[left]) {
                if (target < nums[mid] && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }
        return nums[left] == target || nums[right] == target || result;
    }

    public static void main(String[] args) {
        LeetCode81 l = new LeetCode81();
        System.out.println(l.search(new int[] {2,5,6,0,0,1,2}, 0));
    }
}
