package feture.offer;

import java.util.Stack;

/**
 * @author lanshan
 */
public class Offer30 {

    class MinStack {

        Stack<Integer> num;

        Stack<Integer> min;

        /** initialize your data structure here. */
        public MinStack() {
            num = new Stack<>();
            min = new Stack<>();
        }

        public void push(int x) {
            if (num.isEmpty()) {
                num.push(x);
                min.push(x);
            } else {
                num.push(x);
                if (x < min.peek()) {
                    min.push(x);
                } else {
                    min.push(min.peek());
                }
            }
        }

        public void pop() {
            if (!num.isEmpty()) {
                num.pop();
                min.pop();
            }
        }

        public int top() {
            return num.peek();
        }

        public int min() {
            return min.peek();
        }
    }

}
