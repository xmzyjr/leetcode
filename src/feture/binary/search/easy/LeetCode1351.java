package feture.binary.search.easy;

/**
 * @author lanshan
 */
public class LeetCode1351 {
    class Solution {
        public int countNegatives(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int sum = 0;
            for (int i = 0; i < grid.length; i++) {
                sum += find(grid[i]);
            }
            return sum;
        }
        
        private int find(int[] grid) {
            int left = 0, right = grid.length -1;
            while (left<=right) {
                int mid = left+((right-left)>>1);
                if (grid[mid]>=0) {
                    left = mid + 1;
                } else if (grid[mid]<=0) {
                    right = mid - 1;
                }
            }
            if (left >= grid.length)
                return 0;
            if (right<0)
                return grid.length;
            return grid.length - left;
        }
        
    }
}
