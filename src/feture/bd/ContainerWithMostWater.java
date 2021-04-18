package feture.bd;

/**
 * @author lanshan
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = -1;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
