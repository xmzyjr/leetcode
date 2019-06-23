
package l201906;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class LeetCode1094 {

    public boolean carPooling(int[][] trips, int capacity) {
        if (trips == null || trips.length == 0) {
            return false;
        }
        int[] hash = new int[1001];
//        sort(trips);

        int count = 0;
        for (int[] trip : trips) {
            hash[trip[1]] += trip[0];
            hash[trip[2]] -= trip[0];
        }
        for (int i : hash) {
            count+=i;
            if (count>capacity)
                return false;
        }
        return true;
    }

    public void sort(int[][] num) {
        Arrays.sort(num, (o1, o2) -> {
            if (o1[1] > o2[1]) {
                return 1;
            } else if (o1[1] < o2[1]) {
                return -1;
            } else {
                return o1[2] - o2[2];
            }
        });
    }
}
