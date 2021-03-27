package feture.bd;

import java.util.Stack;

/**
 * @author lanshan
 */
public class TrappingRainWater {
    static class Node {
        int index;
        int val;

        public Node(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        Stack<Node> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] >= stack.peek().val) {
                Node pop = stack.pop();
                if (stack.isEmpty()) {
                    break;
                } else {
                    res += (i - stack.peek().index - 1) * (Math.min(height[i], stack.peek().val) - pop.val);
                }
            }
            stack.push(new Node(i, height[i]));
        }
        return res;
    }

    public static void main(String[] args) {
        TrappingRainWater t = new TrappingRainWater();
        System.out.println(t.trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(t.trap(new int[] {4,2,0,3,2,5}));
    }
}
