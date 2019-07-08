
package l201907;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class LeetCode1109 {

    /**
     * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
     * 我们这儿有一份航班预订表，表中第 i 条预订记录 bookings[i] = [i, j, k] 意味着我们在从 i 到 j 的每个航班上预订了 k
     * 个座位。
     * 请你返回一个长度为 n 的数组 answer，按航班编号顺序返回每个航班上预订的座位数。
     *  
     * 示例：
     * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
     * 输出：[10,55,45,25,25]
     *  
     * 提示：
     * 1 <= bookings.length <= 20000
     * 1 <= bookings[i][0] <= bookings[i][1] <= n <= 20000
     * 1 <= bookings[i][2] <= 10000
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] num = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            int start = bookings[i][0] - 1;
            int end = bookings[i][1];
            num[start] += bookings[i][2];
            if (end < num.length)
                num[end] -= bookings[i][2];
        }
        for (int i = 1; i < num.length; i++) {
            num[i] += num[i - 1];
        }
        return num;
    }

    public static void main(String[] args) {
        LeetCode1109 l = new LeetCode1109();
        System.out.println(Arrays.toString(l.corpFlightBookings(new int[][] {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5)));
    }
}
