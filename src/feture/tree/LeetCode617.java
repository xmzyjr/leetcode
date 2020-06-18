package feture.tree;

/**
 * @author lanshan
 */
public class LeetCode617 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode root;
        root = find(t1, t2);
        if (root == null)
            return null;
        root.left = mergeTrees(t1 != null ? t1.left : null, t2 != null ? t2.left : null);
        root.right = mergeTrees(t1 != null ? t1.right : null, t2 != null ? t2.right : null);
        return root;
    }
    
    public TreeNode find(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return null;
        if (t1 == null)
            return new TreeNode(t2.val);
        if (t2 == null)
            return new TreeNode(t1.val);
        return new TreeNode(t1.val + t2.val);
    }
}
