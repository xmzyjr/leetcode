
package feture.ms;

import java.util.Stack;

/**
 * @author lanshan
 */
public class M1721 {

    /**
     * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
     * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢
     * Marcos 贡献此图。
     * 示例:
     * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出: 6
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                Integer pop = stack.pop();
                if (!stack.isEmpty() && height[stack.peek()] == height[pop])
                    stack.pop();
                if (!stack.isEmpty()) {
                    int h = Math.min(height[stack.peek()] - height[pop], height[i] - height[pop]);
                    int w = i - stack.peek() - 1;
                    res += h * w;
                }
            }
            stack.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        M1721 m = new M1721();
        System.out.println(m.trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
