package l201911;

import java.util.Stack;

/**
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * hit：单调栈
 * @author lanshan
 */
public class LeetCode739 {
    public static class Item {
        public Item(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int value;
        public int index;
    }
    
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return T;
        }
        int[] result = new int[T.length];
        Stack<Item> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            if (stack.empty() || stack.peek().value >= T[i]) {
                stack.push(new Item(T[i], i));
                continue;
            }

            while (!stack.empty() && stack.peek().value < T[i]) {
                Item pop = stack.pop();
                result[pop.index] = i - pop.index;
            }
            stack.push(new Item(T[i], i));
        }
        return result;
    }
}
