package feture.tree.middle;

/**
 * @author lanshan
 */
public class LeetCode236 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null)
                return null;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (root.val == p.val || root.val == q.val)
                return root;
            if (left != null && right != null)
                return root;
            if (left != null)
                return left;
            return right;
        }
    }
}
