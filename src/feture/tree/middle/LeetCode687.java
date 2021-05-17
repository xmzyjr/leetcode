package feture.tree.middle;

/**
 * @author lanshan
 */
public class LeetCode687 {

    /**
     * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
     * 注意：两个节点之间的路径长度由它们之间的边数表示。
     *
     * 示例 1:
     *
     * 输入:
     *
     *               5
     *              / \
     *             4   5
     *            / \   \
     *           1   1   5
     * 输出:
     *
     * 2
     * 示例 2:
     *
     * 输入:
     *
     *               1
     *              / \
     *             4   5
     *            / \   \
     *           4   4   5
     * 输出:
     *
     * 2
     * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
     */
    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int max;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        max = 0;
        find(root);
        return max;
    }

    private int find(TreeNode root) {
        if (root == null)
            return 0;
        int left = find(root.left);
        int right = find(root.right);
        int res = 0;
        boolean leftSame = root.left != null && root.val == root.left.val;
        boolean rightSame = root.right != null && root.val == root.right.val;
        if (leftSame && rightSame) {
            res = Math.max(left, right) + 1;
            max = Math.max(max, left + right + 2);
        } else if (leftSame) {
            res = left + 1;
            max = Math.max(max, res);
        } else if (rightSame) {
            res = right + 1;
            max = Math.max(max, res);
        }
        return res;
    }
}
