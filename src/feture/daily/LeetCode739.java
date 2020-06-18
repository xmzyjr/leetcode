package feture.daily;

import java.util.Stack;

/**
 * @author lanshan
 */
public class LeetCode739 {

    /**
     * 给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]
     *
     * 你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
     */
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return new int[0];
        }
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            if (i == 0) {
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty()) {
                Integer peek = stack.peek();
                if (T[i] > T[peek]) {
                    result[peek] = i - peek;
                    stack.pop();
                } else {
                    stack.push(i);
                    break;
                }
            }
            if (stack.isEmpty()) {
                stack.push(i);
            }
        }
        return result;
    }
}
