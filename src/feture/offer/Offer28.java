package feture.offer;

/**
 * @author lanshan
 */
public class Offer28 {
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
        if (left == null && right == null)
            return true;
        if (left == null)
            return false;
        if (right == null)
            return false;
        if (left.val == right.val)
            return find(left.right, right.left) && find(left.left, right.right);
        return false;
    }
}
