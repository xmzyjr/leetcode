package feture.tree.easy;

/**
 * @author lanshan
 */
public class LeetCode226Offer27 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode ro = new TreeNode(root.val);
        ro.right = mirrorTree(root.left);
        ro.left = mirrorTree(root.right);
        return ro;
    }
}
