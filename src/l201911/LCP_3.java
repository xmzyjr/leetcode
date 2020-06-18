package l201911;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lanshan
 */
public class LCP_3 {
    /**
     * 力扣团队买了一个可编程机器人，机器人初始位置在原点(0, 0)。小伙伴事先给机器人输入一串指令command，机器人就会无限循环这条指令的步骤进行移动。指令有两种：
     *
     * U: 向y轴正方向移动一格
     * R: 向x轴正方向移动一格。
     * 不幸的是，在 xy 平面上还有一些障碍物，他们的坐标用obstacles表示。机器人一旦碰到障碍物就会被损毁。
     *
     * 给定终点坐标(x, y)，返回机器人能否完好地到达终点。如果能，返回true；否则返回false。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：command = "URR", obstacles = [], x = 3, y = 2
     * 输出：true
     * 解释：U(0, 1) -> R(1, 1) -> R(2, 1) -> U(2, 2) -> R(3, 2)。
     * 示例 2：
     *
     * 输入：command = "URR", obstacles = [[2, 2]], x = 3, y = 2
     * 输出：false
     * 解释：机器人在到达终点前会碰到(2, 2)的障碍物。
     * 示例 3：
     *
     * 输入：command = "URR", obstacles = [[4, 2]], x = 3, y = 2
     * 输出：true
     * 解释：到达终点后，再碰到障碍物也不影响返回结果。
     */
    public static class Node {
        int x;
        int y;
    }

    public boolean robot(String command, int[][] obstacles, int x, int y) {
        Set<String> map = null;
        if (obstacles != null && obstacles.length != 0) {
            map = new HashSet<>(obstacles.length);
            fillMap(obstacles, map);
        }
        char[] chars = command.toCharArray();
        Node node = new Node();
        out:
        while (node.x <= x && node.y <= y) {
            for (char aChar : chars) {
                if (aChar == 'U') {
                    node.y++;
                } else if (aChar == 'R') {
                    node.x++;
                }
                if ((map != null && map.contains(node.x + "|" + node.y)) || (node.x == x && node.y == y)) {
                    break out;
                }
            }
        }
        return node.x == x && node.y == y;
    }

    public void fillMap(int[][] obstacles, Set<String> map) {
        for (int[] obstacle : obstacles) {
            map.add(obstacle[0] + "|" + obstacle[1]);
        }
    }


}
