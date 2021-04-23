package feture.offer;

import java.util.Stack;

/**
 * @author lanshan
 */
public class Offer09 {
    class CQueue {

        Stack<Integer> left, right;
        public CQueue() {
            left = new Stack<>();
            right = new Stack<>();
        }

        public void appendTail(int value) {
            left.add(value);
        }

        public int deleteHead() {
            if (left.isEmpty()) {
                return -1;
            }
            while (!left.isEmpty()) {
                right.add(left.pop());
            }
            Integer pop = right.pop();
            while (!right.isEmpty()) {
                left.add(right.pop());
            }
            return pop;
        }
    }

}
