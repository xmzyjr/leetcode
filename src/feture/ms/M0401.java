
package feture.ms;

import java.util.*;

/**
 * @author lanshan
 */
public class M0401 {
    /**
     * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
     *
     * 示例1:
     *
     *  输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
     *  输出：true
     * 示例2:
     *
     *  输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
     *  输出 true
     * 提示：
     *
     * 节点数量n在[0, 1e5]范围内。
     * 节点编号大于等于 0 小于 n。
     * 图中可能存在自环和平行边。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/route-between-nodes-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Node {
        int val;
        List<Node> ways;
        Set<Integer> waySet;

        public Node(int val) {
            this.val = val;
            ways = new ArrayList<>();
            waySet = new HashSet<>();
        }
    }
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        if (graph == null || graph.length == 0)
            return false;
        Map<Integer, Node> map = new HashMap<>(n);
        buildMap(graph, map);
        if (!map.containsKey(start) || !map.containsKey(target))
            return false;
        Set<Integer> visited = new HashSet<>(n);
        Queue<Node> nodeList = new LinkedList<>();
        nodeList.add(map.get(start));
        visited.add(start);
        while (!nodeList.isEmpty()) {
            Node poll = nodeList.poll();
            if (poll.waySet.contains(target))
                return true;
            if (poll.ways.size() > 0) {
                for (Node way : poll.ways) {
                    if (!visited.contains(way.val)) {
                        nodeList.add(way);
                        visited.add(way.val);
                    }
                }
            }
        }
        return false;
    }

    private void buildMap(int[][] graph, Map<Integer, Node> map) {
        for (int[] router : graph) {
            Node node = map.get(router[0]);
            if (node == null) {
                node = new Node(router[0]);
            }
            if (map.containsKey(router[1])) {
                node.waySet.add(router[1]);
                node.ways.add(map.get(router[1]));
            } else {
                Node node2 = new Node(router[1]);
                node.waySet.add(router[1]);
                node.ways.add(node2);
                map.put(router[1], node2);
            }
            map.put(router[0], node);
        }
    }
}
