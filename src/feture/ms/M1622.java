package feture.ms;

import java.util.*;

/**
 * @author lanshan
 */
public class M1622 {
    /**
     * 一只蚂蚁坐在由白色和黑色方格构成的无限网格上。开始时，网格全白，蚂蚁面向右侧。每行走一步，蚂蚁执行以下操作。
     *
     * (1) 如果在白色方格上，则翻转方格的颜色，向右(顺时针)转 90 度，并向前移动一个单位。
     * (2) 如果在黑色方格上，则翻转方格的颜色，向左(逆时针方向)转 90 度，并向前移动一个单位。
     *
     * 编写程序来模拟蚂蚁执行的前 K 个动作，并返回最终的网格。
     *
     * 网格由数组表示，每个元素是一个字符串，代表网格中的一行，黑色方格由 'X' 表示，白色方格由 '_' 表示，
     * 蚂蚁所在的位置由 'L', 'U', 'R', 'D' 表示，分别表示蚂蚁 左、上、右、下 的朝向。只需要返回能够包含蚂蚁走过的所有方格的最小矩形。
     *
     * 示例 1:
     *
     * 输入: 0
     * 输出: ["R"]
     * 示例 2:
     *
     * 输入: 2
     * 输出:
     * [
     *   "_X",
     *   "LX"
     * ]
     * 示例 3:
     *
     * 输入: 5
     * 输出:
     * [
     *   "_U",
     *   "X_",
     *   "XX"
     * ]
     * 说明：
     *
     * K <= 100000
     */
    static class Point {

        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }
    }

    public List<String> printKMoves(int K) {
        if (K <= 0) {
            return Collections.singletonList("R");
        }
        String[] dir = new String[] { "L", "U", "R", "D" };
        int[][] step = new int[][] { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 }};
        int x = 0, y = 0;
        int index = 2;
        Set<Point> black = new HashSet<>();
        Point p = null;
        while (K > 0) {
            p = new Point(x, y);
            if (!black.contains(p)) {
                black.add(p);
                index = (index + 1) % 4;
            } else {
                index = (index + 3) % 4;
                black.remove(p);
            }
            x += step[index][0];
            y += step[index][1];
            K--;
        }
        if (black.size() == 0) {
            return Collections.singletonList(dir[index]);
        }
        int lx = x, ly = y, rx = x, ry = y;
        for (Point point : black) {
            lx = Math.min(lx, point.x);
            ly = Math.min(ly, point.y);
            rx = Math.max(rx, point.x);
            ry = Math.max(ry, point.y);
        }
        int xl = rx - lx + 1;
        int yl = ry - ly + 1;
        char[][] temp = new char[xl][yl];
        for (char[] chars : temp) {
            Arrays.fill(chars, '_');
        }
        for (Point point : black) {
            temp[point.x - lx][point.y - ly] = 'X';
        }
        temp[x- lx][y - ly] = dir[index].charAt(0);
        List<String> res = new ArrayList<>();
        for (char[] chars : temp) {
            res.add(String.valueOf(chars));
        }
        return res;
    }

    public static void main(String[] args) {
        M1622 m = new M1622();
        System.out.println(m.printKMoves(5));
    }
}
