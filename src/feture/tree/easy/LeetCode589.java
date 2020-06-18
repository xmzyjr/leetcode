package feture.tree.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author lanshan
 */
public class LeetCode589 {
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.children == null || root.children.size() == 0) {
            return Collections.singletonList(root.val);
        }
        Stack<Node> stack = new Stack<>();
        List<Integer> re = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            List<Node> children = pop.children;
            if (children!=null && children.size()!=0) {
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.push(children.get(i));
                }
            }
            re.add(pop.val);
        }
        return re;
    }

    private static class Node {
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
}
