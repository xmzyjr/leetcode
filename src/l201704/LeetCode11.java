package l201704;

/**
 * @author lanshan
 */
public class LeetCode11 {

    public int maxArea(int[] height) {
        int[][] num = new int[height.length][height.length];

        for (int i = num.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < num.length; j++) {
                int temp = (j-i)*Math.min(height[i],height[j]);
                num[i][j] = Math.max(temp,Math.max(num[i+1][j],num[i][j-1]));
            }
        }

        return num[0][height.length-1];
    }

    public static void main(String[] args) {
        LeetCode11 l = new LeetCode11();
        System.out.println(l.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    /*
     * func getMaxArea(height []int, index1 int, index2 int) int {
     * if index1 == index2 {
     * return 0
     * }
     * c := index2 - index1
     * k := min(height[index1], height[index2])
     * area := c * k
     * left := getMaxArea(height, index1+1, index2)
     * right := getMaxArea(height, index1, index2-1)
     * return max(area, max(left, right))
     * }
     */
}
