package feture.tree.middle;

/**
 * @author lanshan
 */
public class LeetCode951 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public boolean flipEquiv(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null)
                return true;
            if (root1 == null || root2 == null) {
                return false;
            }
            if (root1.val != root2.val)
                return false;
            boolean left;
            boolean right;
            if (root1.left!=null) {
                if (root2.left == null) {
                    left = flipEquiv(root1.left, root2.right);
                    right = flipEquiv(root1.right, root2.left);
                } else {
                    TreeNode leftNode, rightNode;
                    if (root1.left.val == root2.left.val) {
                        leftNode = root2.left;
                        rightNode = root2.right;
                    }
                    else {
                        leftNode = root2.right;
                        rightNode = root2.left;
                    }
                    left = flipEquiv(root1.left, leftNode);
                    right = flipEquiv(root1.right, rightNode);
                }
            } else {
                if (root2.left == null) {
                    left = true;
                    right = flipEquiv(root1.right, root2.right);
                } else {
                    left = flipEquiv(root1.left, root2.right);
                    right = flipEquiv(root1.right, root2.left);
                }
            }
            return left && right;
        }
    }
}
