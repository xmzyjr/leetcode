
package l201704;

/**
 * @author lanshan
 */
public class LeetCode34 {

    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * 如果数组中不存在目标值，返回 [-1, -1]。
     * 示例 1:
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: [3,4]
     * 示例 2:
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: [-1,-1]
     */
    public int[] searchRange(int[] nums, int target) {
        int[] num = new int[2];
        int left = get(nums,0,nums.length-1,target,true);
        if (left == -1) {
            num[0]=num[1] = -1;
            return num;
        }else {
            num[0] = left;
            nums[1] = get(nums, 0,nums.length-1,target,false);
            return num;
        }
    }

    public int get(int[] nums, int left, int right, int target, boolean flag) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] < target) {
            return get(nums, mid + 1, right, target, flag);
        } else if (nums[mid] > target) {
            return get(nums, left, mid - 1, target, flag);
        } else {
            if (flag) {
                if (mid != 0 && nums[mid - 1] == target) {
                    return get(nums, left, mid - 1, target, flag);
                } else {
                    return mid;
                }
            } else {
                if (mid != nums.length - 1 && nums[mid + 1] == target) {
                    return get(nums, mid + 1, right, target, flag);
                } else {
                    return mid;
                }
            }

        }
    }
}
