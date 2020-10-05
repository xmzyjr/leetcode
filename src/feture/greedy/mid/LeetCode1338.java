
package feture.greedy.mid;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lanshan
 */
public class LeetCode1338 {

    public int minSetSize(int[] arr) {
        int length = arr.length;
        Map<Integer, Integer> map = new HashMap<>(length);
        for (int i : arr) {
            Integer num = map.get(i);
            map.put(i, num == null ? Integer.valueOf(1) : ++num);
        }
        int target = length % 2 == 0 ? length / 2 : length / 2 + 1;
        Integer[] values = map.values().toArray(new Integer[0]);
        Arrays.sort(values, (o1, o2) -> o2 - o1);
        int sum = 0, count = 0;
        for (Integer num : values) {
            sum += num;
            count++;
            if (sum >= target)
                break;
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode1338 l = new LeetCode1338();
        System.out.println(l.minSetSize(new int[] {3, 3, 3, 3, 5, 5, 5, 2, 2, 7}));
        System.out.println(l.minSetSize(new int[] {7,7,7,7,7,7}));
        System.out.println(l.minSetSize(new int[] {1,9}));
        System.out.println(l.minSetSize(new int[] {1000,1000,3,7}));
        System.out.println(l.minSetSize(new int[] {1,2,3,4,5,6,7,8,9,10}));
    }
}
