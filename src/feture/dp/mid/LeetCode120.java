package feture.dp.mid;

import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode120 {
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            if (triangle == null || triangle.size() == 0)
                return 0;
            return find(triangle, 0,0,0);
        }
        
        private int find(List<List<Integer>> triangle, int row, int col, int sum) {
            if (row == triangle.size() - 1) {
                return sum + triangle.get(row).get(col);
            }
            sum += triangle.get(row).get(col);
            int down = find(triangle, row+1, col, sum);
            int downRight = find(triangle, row + 1, col + 1, sum);
            return Math.min(down, downRight);
        }
        
        public int minimumTotal2(List<List<Integer>> triangle) {
            if (triangle == null || triangle.size() == 0)
                return 0;
            int[] sum = new int[triangle.size()];
            for (int i = triangle.size() - 1; i >= 0; i--) {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    if (i == triangle.size() - 1) {
                        sum[j] = triangle.get(i).get(j);    
                    } else {
                        sum[j] = triangle.get(i).get(j) + Math.min(sum[j], sum[j + 1]);
                    }
                }
            }
            return sum[0];
        }
    }
}
