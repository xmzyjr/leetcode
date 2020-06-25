package feture.tree.middle;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lanshan
 */
public class LeetCode1261 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class FindElements {

        private final Set<Integer> targets;
        public FindElements(TreeNode root) {
            targets = new HashSet<>();
            build(root, 0);
        }

        private void build(TreeNode root, int value) {
            if (root == null)
                return;
            root.val = value;
            targets.add(value);
            build(root.left, 2 * value + 1);
            build(root.right, 2 * value + 2);
        }

        public boolean find(int target) {
            return targets.contains(target);
        }
    }
}
