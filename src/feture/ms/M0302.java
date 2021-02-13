package feture.ms;

import java.util.Stack;

/**
 * @author lanshan
 */
public class M0302 {
    /**
     * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
     *
     *
     * 示例：
     *
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.getMin();   --> 返回 -2.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/min-stack-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class MinStack {

        Stack<Integer> stack;
        Stack<Integer> minStack;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty()) {
                minStack.push(x);
            } else {
                int min = Math.min(minStack.peek(), x);
                minStack.push(min);
            }
        }

        public void pop() {
            if (!stack.isEmpty()) {
                stack.pop();
                minStack.pop();
            }
        }

        public int top() {
            if (stack.isEmpty())
                return 0;
            return stack.peek();
        }

        public int getMin() {
            if (stack.isEmpty())
                return 0;
            return minStack.peek();
        }
    }
}
