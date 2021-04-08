package feture.bd;

import java.util.Stack;

/**
 * @author lanshan
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        Stack<Integer> s = new Stack<>();
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            if (s.isEmpty() || heights[i]>= heights[s.peek()]) {
                s.add(i);
            } else {
                while (!s.isEmpty() && heights[s.peek()] > heights[i]) {
                    Integer pop = s.pop();
                    int left = s.isEmpty() ? -1 : s.peek();
                    ans = Math.max(ans, (i - left - 1) * heights[pop]);
                }
                s.add(i);
            }
        }
        while (!s.isEmpty()) {
            Integer pop = s.pop();
            int left = s.isEmpty() ? -1 : s.peek();
            ans = Math.max(ans, (heights.length - left - 1) * heights[pop]);
        }
        return ans;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram l = new LargestRectangleInHistogram();
        System.out.println(l.largestRectangleArea(new int[] {2, 1, 5, 6, 2, 3}));
    }
}
