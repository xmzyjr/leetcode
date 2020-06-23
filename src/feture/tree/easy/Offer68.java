package feture.tree.easy;

/**
 * @author lanshan
 */
public class Offer68 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {

        TreeNode result;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            result = null;
            find(root, p.val, q.val);
            return result;
        }

        private int find(TreeNode root, int p, int q) {
            if (root == null || result != null)
                return 0;
            int left = find(root.left, p, q);
            int right = find(root.right, p, q);
            if (result != null) {
                return 0;
            }
            if (left == 2) {
                result = root.left;
            } else if (right == 2) {
                result = root.right;
            } else if (left + right == 2) {
                result = root;
            }
            int now = 0;
            if (root.val == p || root.val == q) {
                now = 1;
            }
            now = left + right + now;
            if (now == 2) {
                result = root;
            }
            return now;
        }
    }
}
