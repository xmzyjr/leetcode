package feture.tree.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode429 {
    public class Node {
        public int val;
        public List<Node> children;
        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        find(root, 1, result);
        return result;
    }

    private void find(Node root, int level, List<List<Integer>> result) {
        if (root == null)
            return;
        if (level > result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(level - 1).add(root.val);
        if (root.children == null) {
            return;
        }
        for (Node child : root.children) {
            find(child, level+1, result);
        }
    }
}
