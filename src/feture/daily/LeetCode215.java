package feture.daily;

import java.util.PriorityQueue;

/**
 * @author lanshan
 */
public class LeetCode215 {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for (int num : nums) {
            heap.add(num);
        }
        int result = 0;
        while (!heap.isEmpty() && k-- > 0) {
            result = heap.poll();
        }
        return result;
    }
}
