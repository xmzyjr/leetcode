package feture.tree.middle;

/**
 * @author lanshan
 */
public class LeetCode979 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int ans;
    public int distributeCoins(TreeNode root) {
        ans = 0;
        find(root);
        return ans;
    }

    private int find(TreeNode treeNode) {
        if (treeNode == null)
            return 0;
        int left = find(treeNode.left);
        int right = find(treeNode.right);
        ans += Math.abs(left) + Math.abs(right);
        return treeNode.val + left + right - 1;
    }
}
