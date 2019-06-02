
package l201906;

/**
 * @author lanshan
 */
public class LeetCode57 {

    /**
     * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
     * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
     * 示例 1:
     * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
     * 输出: [[1,5],[6,9]]
     * 示例 2:
     * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     * 输出: [[1,2],[3,10],[12,16]]
     * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][] { newInterval };
        }
        int[][] temp = new int[intervals.length + 1][2];
        int index = 0;
        boolean leftFlag = false, rightFlag = false;
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (!leftFlag) {
                if (newInterval[0] >= left && newInterval[0] <= right) {
                    leftFlag = true;
                    temp[index][0] = left;
                } else if (newInterval[0] < left) {
                    leftFlag = true;
                    temp[index][0] = newInterval[0];
                } else {
                    temp[index++] = intervals[i];
                }
            }
            if (!rightFlag) {
                if (newInterval[1] >= left && newInterval[1] <= right) {
                    rightFlag = true;
                    temp[index++][1] = right;
                    continue;
                } else if (newInterval[1] < left) {
                    rightFlag = true;
                    temp[index++][1] = newInterval[1];
                    temp[index++] = intervals[i];
                    continue;
                }
            }
            if (rightFlag && leftFlag) {
                temp[index++] = intervals[i];
            }
        }
        if (!leftFlag) {
            temp[index++] = newInterval;
        } else if (!rightFlag) {
            temp[index++][1] = newInterval[1];
        }
        int[][] res = new int[index][2];
        System.arraycopy(temp, 0, res, 0, index);
        return res;
    }

    public static void main(String[] args) {
        LeetCode57 l = new LeetCode57();
        l.insert(new int[][] { { 1, 5 } }, new int[] { 0, 3 });
    }

}
