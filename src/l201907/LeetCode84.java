
package l201907;

/**
 * @author lanshan
 */
public class LeetCode84 {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int max = 0, len = 1;
        for (int i = 0; i < heights.length; i++) {
            int left = i - 1, right = i + 1;
            len = 1;
            while (left >= 0) {
                if (heights[left] >= heights[i] && heights[i] > 0) {
                    len++;
                    left--;
                } else {
                    break;
                }
            }

            while (right < heights.length) {
                if (heights[right] >= heights[i] && heights[i] > 0) {
                    len++;
                    right++;
                } else {
                    break;
                }
            }
            int sum = heights[i] * len;
            max = sum > max ? sum : max;
        }
        return max;
    }
}
