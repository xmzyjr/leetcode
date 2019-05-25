
package l201705;

/**
 * @author lanshan
 */
public class LeetCode42 {

    public int trap(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int left = 0;
        int sum = 0;
        while (left < height.length) {
            while (left < height.length && height[left] == 0) {
                left++;
            }
            int rightIndex = rightMax(height, left);
            if (rightIndex == -1) {
                break;
            } else {
                sum += ((rightIndex - left + 1) * Math.min(height[rightIndex], height[left])
                        - rightLeftSum(left, rightIndex, height) + Math.abs(height[rightIndex] - height[left]));
                left = rightIndex;
            }
        }
        return sum;
    }

    public int rightMax(int[] height, int left) {
        int max = left < height.length - 1 ? height[left + 1] : -1;
        int maxIndex = max == -1 ? -1 : left + 1;
        for (int i = left + 1; i < height.length; i++) {
            if (height[i] >= max) {
                max = height[i];
                maxIndex = i;
                if (max >= height[left]) {
                    break;
                }
            }
        }
        return maxIndex;
    }

    public int rightLeftSum(int left, int right, int[] height) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += height[i];
        }
        return sum;
    }

    /**
     * [0,5,6,4,6,1,0,0,2,7]
     */
    public static void main(String[] args) {
        LeetCode42 l = new LeetCode42();
        System.out.println(l.trap(new int[] { 0,5,6,4,6,1,0,0,2,7 }));
    }
}
