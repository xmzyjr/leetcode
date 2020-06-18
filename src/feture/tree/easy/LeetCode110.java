package feture.tree.easy;

/**
 * @author lanshan
 */
public class LeetCode110 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    boolean isB;
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        isB = true;
        find(root);
        return isB;
    }
    
    private int find(TreeNode root) {
        if (root == null || !isB)
            return 0;
        int left = find(root.left);
        int right = find(root.right);
        isB &= Math.abs(left - right) <= 1;
        return Math.max(left, right) + 1;
    }
}
