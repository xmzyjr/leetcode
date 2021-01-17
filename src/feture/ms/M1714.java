package feture.ms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author lanshan
 */
public class M1714 {
    /**
     * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
     *
     * 示例：
     *
     * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
     * 输出： [1,2,3,4]
     * 提示：
     *
     * 0 <= len(arr) <= 100000
     * 0 <= k <= min(100000, len(arr))
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/smallest-k-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int[] smallestK(int[] arr, int k) {
        if (arr == null || arr.length== 0 || k<=0)
            return new int[0];
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, Comparator.comparingInt(o -> o));
        for (int i : arr) {
            heap.add(i);
        }
        int[] res = new int[k];
        int j = 0;
        
        while (!heap.isEmpty() && j < k) {
            res[j++] = heap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        M1714 m = new M1714();
        System.out.println(Arrays.toString(m.smallestK(new int[] {1, 3, 5, 7, 2, 4, 6, 8}, 4)));
    }
}
