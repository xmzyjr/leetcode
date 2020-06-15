package feture.tree;

/**
 * @author lanshan
 */
public class LeetCode101 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return find(root.left, root.right);
    }
    
    private boolean find(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        boolean child = find(left.left, right.right) & find(left.right, right.left);
        return left.val == right.val & child;
    }
}
