
package l201907;

import java.util.Stack;

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

    public int largestRectangleArea2(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while (i != 0 && stack.size() > 1 && heights[stack.peek()] >= heights[i]) {
                max = Math.max(heights[stack.pop()]* (i - stack.peek() - 1), max);
            }
            stack.push(i);
        }
        Integer top = null;
        if (stack.size() > 1) {
            top = stack.peek();
        }
        while (stack.size() > 1) {
            int now = stack.pop();
            max = Math.max(max, (top - stack.peek()) * heights[now]);
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode84 l = new LeetCode84();
        System.out.println(l.largestRectangleArea2(new int[] { 2, 1, 5, 6, 2, 3 }));
    }

    public int large(int[] heights) {
        Stack < Integer > stack = new Stack < > ();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() -1));
        return maxarea;
    }
}
