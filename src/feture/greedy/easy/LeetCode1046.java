package feture.greedy.easy;

import java.util.PriorityQueue;

/**
 * @author lanshan
 */
public class LeetCode1046 {
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0)
            return 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(stones.length, (o1, o2) -> o2 - o1);
        for (int stone : stones) {
            heap.add(stone);
        }
        while (!heap.isEmpty()) {
            Integer stone1 = heap.poll();
            if (heap.isEmpty()) {
                return stone1;
            }
            Integer stone2 = heap.poll();
            heap.add(stone1 - stone2);
        }
        return 0;
    }

    public static void main(String[] args) {
        LeetCode1046 l = new LeetCode1046();
        System.out.println(l.lastStoneWeight(new int[] {2,7,4,1,8,1}));
    }
}
