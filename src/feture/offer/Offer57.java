package feture.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class Offer57 {
    /**
     * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
     *
     * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
     *
     * 示例 1：
     *
     * 输入：target = 9
     * 输出：[[2,3,4],[4,5]]
     * 示例 2：
     *
     * 输入：target = 15
     * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
     *  
     *
     * 限制：
     *
     * 1 <= target <= 10^5
     */
    public int[][] findContinuousSequence(int target) {
        if (target <= 2) {
            return new int[0][0];
        }
        int left = 1, right = 2;
        int sum = 3;
        List<int[]> res = new ArrayList<>();
        while (left < right) {
            if (sum < target) {
                right++;
                sum += right;
            } else if (sum > target) {
                left++;
                sum -= (left - 1);
            } else {
                add(left, right, res);
                right++;
                sum += right;
            }
        }
        return res.toArray(new int[0][]);
    }

    private void add(int left, int right, List<int[]> res) {
        int[] t = new int[right - left + 1];
        int index = 0;
        for (int i = left; i <= right; i++) {
            t[index++] = i;
        }
        res.add(t);
    }

    public static void main(String[] args) {
        Offer57 o = new Offer57();
        o.findContinuousSequence(9);
        o.findContinuousSequence(15);
    }
}
