package feture.ms;

import java.util.Stack;

/**
 * @author lanshan
 */
public class M0304 {
    /**
     * 实现一个MyQueue类，该类用两个栈来实现一个队列。
     *
     *
     * 示例：
     *
     * MyQueue queue = new MyQueue();
     *
     * queue.push(1);
     * queue.push(2);
     * queue.peek();  // 返回 1
     * queue.pop();   // 返回 1
     * queue.empty(); // 返回 false
     *
     * 说明：
     *
     * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
     * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
     * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
     */
    class MyQueue {
        private Stack<Integer> s1;
        private Stack<Integer> s2;


        /** Initialize your data structure here. */
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            s1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            Integer res = null;
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            res = s2.pop();
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            return res;
        }

        /** Get the front element. */
        public int peek() {
            return s1.elementAt(0);
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return s1.isEmpty();
        }
    }

}
