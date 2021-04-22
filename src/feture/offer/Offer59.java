package feture.offer;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author lanshan
 */
public class Offer59 {

    /**
     * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
     *
     * 示例:
     *
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     * 解释:
     *
     *   滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     */

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[0];
        LinkedList<Integer> q = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        res[0] = init(nums, k, q);
        int left = 0, right = k - 1;
        int resIndex = 0;

        while (right < nums.length) {
            if (!q.isEmpty() && nums[left] == q.peekFirst()) {
                q.poll();
            }
            left++;
            right++;
            if (right < nums.length) {
                while (!q.isEmpty() && nums[right] > q.peekLast()) {
                    q.pollLast();
                }
                q.add(nums[right]);
                res[++resIndex] = q.peekFirst();
            }
        }
        return res;
    }

    public int init(int[] nums, int k, LinkedList<Integer> q) {
        int max = nums[0];
        for (int i = 0; i < k; i++) {
            max = Math.max(nums[i], max);
            while (!q.isEmpty() && nums[i] > q.peekLast()) {
                q.pollLast();
            }
            q.add(nums[i]);
        }
        return max;
    }

    /**
     * [1,3,1,2,0,5]
     * 3
     */
    public static void main(String[] args) {
        Offer59 o = new Offer59();
        System.out.println(Arrays.toString(o.maxSlidingWindow(new int[] { 1, 3, 1, 2, 0, 5 }, 3)));
    }
}
