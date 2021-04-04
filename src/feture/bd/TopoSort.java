package feture.bd;

import java.util.*;

/**
 * @author lanshan
 */
public class TopoSort {

    /**
     * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
     *
     * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
     *
     * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
     * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：numCourses = 2, prerequisites = [[1,0]]
     * 输出：true
     * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
     * 示例 2：
     *
     * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
     * 输出：false
     * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
     *  
     *
     * 提示：
     *
     * 1 <= numCourses <= 105
     * 0 <= prerequisites.length <= 5000
     * prerequisites[i].length == 2
     * 0 <= ai, bi < numCourses
     * prerequisites[i] 中的所有课程对 互不相同
     */
    static class LeetCode207 {

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (prerequisites == null || prerequisites.length == 0) {
                return false;
            }
            LinkedList<Integer>[] list = new LinkedList[numCourses];
            int[] count = new int[numCourses];
            Arrays.fill(count, -1);
            for (int[] p : prerequisites) {
                LinkedList l = list[p[1]];
                if (l == null) {
                    l = new LinkedList();
                }
                l.add(p[0]);
                list[p[1]] = l;
                if (count[p[1]] == -1) {
                    count[p[1]] = 0;
                }
                if (count[p[0]] == -1) {
                    count[p[0]] = 1;
                } else {
                    count[p[0]]++;
                }
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < count.length; i++) {
                if (count[i] == 0)
                    queue.add(i);
            }
            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                LinkedList<Integer> linkedList = list[poll];
                if (linkedList != null) {
                    for (Integer i : linkedList) {
                        count[i]--;
                        if (count[i] == 0) {
                            queue.add(i);
                        }
                    }
                }
            }
            for (int i : count) {
                if (i > 0)
                    return false;
            }
            return true;
        }

        public static void main(String[] args) {
        }
    }

    static class LeetCode210 {

    }

    static class LeetCode329 {

        int[][] temp;

        public int longestIncreasingPath(int[][] matrix) {
            if (matrix == null || matrix.length == 0)
                return 0;
            temp = new int[matrix.length][matrix[0].length];
            int max = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    int t = find(matrix, i, j);
                    max = Math.max(t, max);
                }
            }
            return max;
        }

        private int find(int[][] matrix, int x, int y) {
            if (temp[x][y] != 0) {
                return temp[x][y];
            }
            ++temp[x][y];
            if (canGo(matrix, x + 1, y, matrix[x][y])) {
                temp[x][y] = Math.max(find(matrix, x + 1, y) + 1, temp[x][y]);
            }
            if (canGo(matrix, x, y - 1, matrix[x][y])) {
                temp[x][y] = Math.max(find(matrix, x, y - 1) + 1, temp[x][y]);
            }
            if (canGo(matrix, x - 1, y, matrix[x][y])) {
                temp[x][y] = Math.max(find(matrix, x - 1, y) + 1, temp[x][y]);
            }
            if (canGo(matrix, x, y + 1, matrix[x][y])) {
                temp[x][y] = Math.max(find(matrix, x, y + 1) + 1, temp[x][y]);
            }
            return temp[x][y];
        }

        private boolean canGo(int[][] matrix, int x, int y, int now) {
            return x >= 0 && y >= 0 && x < matrix.length && y < matrix[x].length && matrix[x][y] > now;
        }
    }



}
