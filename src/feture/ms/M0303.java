package feture.ms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class M0303 {

    /**
     * 示例1:
     *
     *  输入：
     * ["StackOfPlates", "push", "push", "popAt", "pop", "pop"]
     * [[1], [1], [2], [1], [], []]
     *  输出：
     * [null, null, null, 2, 1, -1]
     * 示例2:
     *
     *  输入：
     * ["StackOfPlates", "push", "push", "push", "popAt", "popAt", "popAt"]
     * [[2], [1], [2], [3], [0], [0], [0]]
     *  输出：
     * [null, null, null, null, 2, 1, 3]
     */
    static class StackOfPlates {

        List<List<Integer>> stack;
        int cap;

        public StackOfPlates(int cap) {
            this.cap = cap;
            stack = new ArrayList<>();
        }

        public void push(int val) {
            if (cap <= 0)
                return;
            if (stack.size() == 0) {
                List<Integer> newStack = new ArrayList<>(cap);
                newStack.add(val);
                stack.add(newStack);
            } else {
                List<Integer> target = stack.get(stack.size() - 1);
                if (target.size() == cap) {
                    List<Integer> newStack = new ArrayList<>(cap);
                    newStack.add(val);
                    stack.add(newStack);
                } else {
                    target.add(val);
                }
            }
        }

        public int pop() {
            if (cap <= 0)
                return -1;
            if (stack.size() == 0)
                return -1;
            List<Integer> target = stack.get(stack.size() - 1);
            int res = target.get(target.size()-1);
            if (target.size() == 1) {
                stack.remove(stack.size()-1);
            } else {
                target.remove(target.size()-1);
            }
            return res;
        }

        public int popAt(int index) {
            if (cap <= 0)
                return -1;
            if (index+1 > stack.size())
                return -1;
            List<Integer> target = stack.get(index);
            int res = target.get(target.size() - 1);
            if (target.size() == 1) {
                stack.remove(index);
            } else {
                target.remove(target.size() - 1);
            }
            return res;
        }
    }

    public static void main(String[] args) {
    }
}
