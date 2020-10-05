package feture.greedy.mid;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class LeetCode1029 {

    public int twoCitySchedCost(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;
        Arrays.sort(costs, (o1, o2) -> o1[0] - o1[1] - (o2[0] - o2[1]));
        int count = costs.length / 2;
        int sum = 0;
        for (int i = 0; i < costs.length; i++) {
            sum += i < count ? costs[i][0] : costs[i][1];
        }
        return sum;
    }
}
