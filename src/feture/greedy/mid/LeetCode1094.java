
package feture.greedy.mid;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class LeetCode1094 {

    public boolean carPooling(int[][] trips, int capacity) {
        if (trips == null || trips.length == 0)
            return false;
        Arrays.sort(trips, ((o1, o2) -> {
            if (o1[1] == o2[1])
                return o1[2] - o2[2];
            return o1[1] - o2[1];
        }));
        int[] up = new int[1001];
        int[] down = new int[1001];
        int start = 1001, end = 0;
        for (int[] trip : trips) {
            up[trip[1]] += trip[0];
            down[trip[2]] += trip[0];
            start = Math.min(start, trip[1]);
            end = Math.max(end, trip[2]);
        }
        int now = 0;
        for (int i = start; i <= end ; i++) {
            now -= down[i];
            now += up[i];
            if (now > capacity)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode1094 l = new LeetCode1094();

    }
}
