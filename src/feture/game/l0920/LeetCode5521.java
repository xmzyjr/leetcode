package feture.game.l0920;

/**
 * @author lanshan
 */
public class LeetCode5521 {

    static class Node {
        Integer max;
        Integer min;

        public Node(Integer max, Integer min) {
            this.max = max;
            this.min = min;
        }
    }

    int mod = 1000000007;

    public int maxProductPath(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Node[][] res = new Node[row][col];
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i == row - 1 && j == col - 1) {
                    res[i][j] = new Node(grid[i][j], grid[i][j]);
                    continue;
                }
                int now = grid[i][j];
                Integer tempMax = null, tempMin = null;
                if (j + 1 < col) {
                    Node node = res[i][j + 1];
                    tempMax = Math.max((now * node.max), (now * node.min));
                    tempMin = Math.min((now * node.max), (now * node.min));
                }
                if (i + 1 < row) {
                    Node node = res[i + 1][j];
                    int tempMax1 = Math.max((now * node.max), (now * node.min));
                    int tempMin1 = Math.min((now * node.max), (now * node.min));
                    tempMax = tempMax == null ? tempMax1 : Math.max(tempMax, tempMax1);
                    tempMin = tempMin == null ? tempMin1 : Math.min(tempMin, tempMin1);
                }
                res[i][j] = new Node(tempMax, tempMin);
            }
        }
        return res[0][0].max < 0 ? -1 : res[0][0].max % mod;
    }

    /**
     * [[2,1,3,0,-3,3,-4,4,0,-4],
     * [-4,-3,2,2,3,-3,1,-1,1,-2],
     * [-2,0,-4,2,4,-3,-4,-1,3,4],
     * [-1,0,1,0,-3,3,-2,-3,1,0],
     * [0,-1,-2,0,-3,-4,0,3,-2,-2],
     * [-4,-2,0,-1,0,-3,0,4,0,-3],
     * [-3,-4,2,1,0,-4,2,-4,-1,-3],
     * [3,-2,0,-4,1,0,1,-3,-1,-1],
     * [3,-4,0,2,0,-2,2,-4,-2,4],
     * [0,4,0,-3,-4,3,3,-1,-2,-2]]
     *
     * 19215865
     */
    public static void main(String[] args) {
        LeetCode5521 l = new LeetCode5521();
        System.out.println(l.maxProductPath(new int[][] {{2, 1, 3, 0, -3, 3, -4, 4, 0, -4}, {-4, -3, 2, 2, 3, -3, 1, -1, 1, -2}, {-2, 0, -4, 2, 4, -3, -4, -1, 3, 4}
                , {-1, 0, 1, 0, -3, 3, -2, -3, 1, 0}, {0, -1, -2, 0, -3, -4, 0, 3, -2, -2}, {-4, -2, 0, -1, 0, -3, 0, 4, 0, -3}, {-3, -4, 2, 1, 0, -4, 2, -4, -1, -3},
                {3, -2, 0, -4, 1, 0, 1, -3, -1, -1}, {3, -4, 0, 2, 0, -2, 2, -4, -2, 4}, {0, 4, 0, -3, -4, 3, 3, -1, -2, -2}}));
    }
}
