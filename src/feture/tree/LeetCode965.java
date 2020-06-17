package feture.tree;

/**
 * @author lanshan
 */
public class LeetCode965 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isUnivalTree(TreeNode root) {
        return find(root, root.val);
    }

    private boolean find(TreeNode root, int value) {
        if (root == null)
            return true;
        if (root.val!=value)
            return false;
        boolean left = find(root.left, value);
        if (!left)
            return false;
        return find(root.right, value);
    }
}
