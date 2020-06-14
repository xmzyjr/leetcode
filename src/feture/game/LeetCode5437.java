package feture.game;

import java.util.*;

/**
 * @author lanshan
 */
public class LeetCode5437 {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>(64);
        for (int i = 0; i < arr.length; i++) {
            Integer integer = map.get(arr[i]);
            if (integer == null)
                map.put(arr[i], 1);
            else
                map.put(arr[i], ++integer);
        }
        if (k == 0) {
            return map.size();
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(map.size(),
                Comparator.comparingInt(Map.Entry::getValue));
        heap.addAll(entries);
        while (!heap.isEmpty() && k > 0) {
            Map.Entry<Integer, Integer> peek = heap.peek();
            Integer value = peek.getValue();
            if (k >= value) {
                heap.poll();
                k -= value;
            } else {
                break;
            }
        }
        return heap.size();
    }
}
