package feture.ms;

import java.util.Stack;

/**
 * @author lanshan
 */
public class M0305 {
    /**
     * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。
     * 该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
     *
     * 示例1:
     *
     *  输入：
     * ["SortedStack", "push", "push", "peek", "pop", "peek"]
     * [[], [1], [2], [], [], []]
     *  输出：
     * [null,null,null,1,null,2]
     * 示例2:
     *
     *  输入：
     * ["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
     * [[], [], [], [1], [], []]
     *  输出：
     * [null,null,null,null,null,true]
     * 说明:
     *
     * 栈中的元素数目在[0, 5000]范围内。
     *
     */
    class SortedStack {
        Stack<Integer> num, temp;

        public SortedStack() {
            num = new Stack<>();
            temp = new Stack<>();
        }

        public void push(int val) {
            if (num.isEmpty()) {
                num.push(val);
            } else {
                while (!num.isEmpty() && num.peek()<val) {
                    temp.push(num.pop());
                }
                num.push(val);
                while (!temp.isEmpty()) {
                    num.push(temp.pop());
                }
            }
        }

        public void pop() {
            if (!num.isEmpty()) {
                num.pop();
            }
        }

        public int peek() {
            if (num.isEmpty())
                return -1;
            return num.peek();
        }

        public boolean isEmpty() {
            return num.isEmpty();
        }
    }
}
