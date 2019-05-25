
package l201704;

/**
 * @author lanshan
 */
public class LeetCode33 {

    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     * 你可以假设数组中不存在重复的元素。
     * 你的算法时间复杂度必须是 O(log n) 级别。
     */
    public int search(int[] nums, int target) {
        return get(nums, 0, nums.length - 1, target);
    }

    public int get(int[] num, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (num[mid] == target) {
            return mid;
        }
        // in right fragment or in standard fragment
        if (num[mid] < num[right]) {
            if (num[mid] <= target && target <= num[right]) {
                return get(num, mid + 1, right, target);
            } else {
                return get(num, left, mid - 1, target);
            }
            // in left fragment
        } else {
            if (num[left] <= target && target <= num[mid]) {
                return get(num, left, mid - 1, target);
            } else {
                return get(num, mid + 1, right, target);
            }
        }
    }

    /**
     * [4,5,6,7,0,1,2]
     * 1
     *
     * [1,3]
     * 2
     */
    public static void main(String[] args) {
        LeetCode33 l = new LeetCode33();
        System.out.println(l.search(new int[] {4,5,6,7,0,1,2}, 1));
    }

}
