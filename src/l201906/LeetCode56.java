
package l201906;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class LeetCode56 {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] > o2[0]) {
                return 1;
            } else if (o1[0] < o2[0]) {
                return -1;
            } else {
                return o1[1] - o2[1];
            }
        });

        int[][] temp = new int[intervals.length][2];
        int index = 0;
        temp[index] = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int x = intervals[i][0], y = intervals[i][1];
            if (x > temp[index][1]) {
                temp[++index] = intervals[i];
            }
            if (x >= temp[index][0] && x <= temp[index][1] && y > temp[index][1]) {
                temp[index][1] = y;
            }
        }

        boolean flag = false;
        int len = 1;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i][0] == 0 && flag) {
                break;
            }
            if (temp[i][0] != 0) {
                flag = true;
                len = i == 0 ? 1 : ++len;
            }
        }

        int[][] res = new int[len][2];
        System.arraycopy(temp, 0, res, 0, len);
        return res;
    }

    public static void main(String[] args) {
        LeetCode56 l = new LeetCode56();
        int[][] merge = l.merge(new int[][] {{1, 3}, {2, 3}, {6, 8}, {5, 10}});
        for (int i = 0; i < merge.length; i++) {
            System.out.println(Arrays.toString(merge[i]));
        }
    }

}
