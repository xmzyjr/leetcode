package feture.ms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author lanshan
 */
public class M1619 {
    /**
     * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。
     * 若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
     * 示例：
     * 输入：
     * [
     * [0,2,1,0],
     * [0,1,0,1],
     * [1,1,0,1],
     * [0,1,0,1]
     * ]
     * 输出： [1,2,4]
     * 提示：
     * 0 < len(land) <= 1000
     * 0 < len(land[i]) <= 1000
     */
    List<Integer> res;
    int[][] tempLand;
    public int[] pondSizes(int[][] land) {
        if (land == null || land.length == 0)
            return new int[0];
        res = new ArrayList<>();
        tempLand = new int[land.length][land[0].length];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                int k = find(land, i, j);
                if (k != 0)
                    res.add(k);
            }
        }
        if (res.isEmpty())
            return new int[0];
        else {
            int[] num = res.stream().mapToInt(i -> i).toArray();
            Arrays.sort(num);
            return num;
        }
    }

    private int find(int[][] land, int x, int y) {
        if (x < 0 || x >= land.length || y < 0 || y >= land[0].length)
            return 0;
        if (land[x][y] == 0 && tempLand[x][y] == 0) {
            tempLand[x][y] = 1;
            return find(land, x + 1, y) + find(land, x + 1, y - 1) + find(land, x + 1, y + 1) + find(land, x, y + 1)
                    + find(land, x, y - 1) + find(land, x - 1, y - 1) + find(land, x - 1, y) + find(land, x - 1, y + 1)
                    + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        M1619 m = new M1619();
        System.out.println(Arrays.toString(m.pondSizes(new int[][] {{0, 2, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 1}, {0, 1, 0, 1}})));
    }
}
