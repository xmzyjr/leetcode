package feture.dp.mid;

import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode120 {

    /**
     *
     给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

     相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。



     例如，给定三角形：

     [
     [2],
     [3,4],
     [6,5,7],
     [4,1,8,3]
     ]
     自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。



     */
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
