
package l201904;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class LeetCode1029 {

    public int twoCitySchedCost(int[][] costs) {
        //        return get(costs, costs.length / 2, costs.length / 2, 0, 0);
        Arrays.sort(costs, ((o1, o2) -> {
            if (o1[0] > o2[0]) {
                return 1;
            } else if (o1[0] < o2[0]) {
                return -1;
            } else {
                return o1[1] - o2[1];
            }
        }));
        int left = get(costs);
        Arrays.sort(costs, ((o1, o2) -> {
            if (o1[0] < o2[0]) {
                return 1;
            } else if (o1[0] > o2[0]) {
                return -1;
            } else {
                return o2[1] - o1[1];
            }
        }));
        int right = get(costs);

        return Math.min(left, right);
    }

    public int get(int[][] costs) {
        int left = costs.length / 2;
        int right = costs.length / 2;
        int sum = 0;
        for (int[] cost : costs) {
            if (cost[0] < cost[1]) {
                if (left > 0) {
                    sum += cost[0];
                    left--;
                } else {
                    sum += cost[1];
                    right--;
                }
            } else {
                if (right > 0) {
                    sum += cost[1];
                    right--;
                } else {
                    sum += cost[0];
                    left--;
                }
            }
        }
        return sum;
    }

    public int get(int[][] costs, int index1, int index2, int now) {

        if (index1 < 0 || index2 < 0) {
            return Integer.MAX_VALUE;
        }
        if (index1 == 0 && index2 == 0) {
            return 0;
        }
        int left = get(costs, index1 - 1, index2, now + 1) + costs[now][0];
        int right = get(costs, index1, index2 - 1, now + 1) + costs[now][1];
        return Math.min(left, right);
    }

    public static void main(String[] args) {
        LeetCode1029 l = new LeetCode1029();
        System.out.println(l.twoCitySchedCost(
                new int[][] { { 259, 770 }, { 448, 54 }, { 926, 667 }, { 184, 139 }, { 840, 118 }, { 577, 469 } }));

    }
}
