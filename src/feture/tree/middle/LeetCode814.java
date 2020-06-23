package feture.tree.middle;

/**
 * @author lanshan
 */
public class LeetCode814 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public TreeNode pruneTree(TreeNode root) {
            if (root == null)
                return null;
            if (root.left == null && root.right == null && root.val == 0)
                return null;
            find(root);
            return root;
        }
        
        private boolean find(TreeNode root) {
            if (root == null)
                return false;
            boolean left = find(root.left);
            boolean right = find(root.right);
            if (!left)
                root.left = null;
            if (!right)
                root.right = null;
            return left || right || root.val == 1;
        }
    }
}
