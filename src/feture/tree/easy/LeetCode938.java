package feture.tree.easy;

/**
 * @author lanshan
 */
public class LeetCode938 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    int result;

    public int rangeSumBST(TreeNode root, int L, int R) {
        result = 0;
        if (root == null || L > R)
            return 0;

        find(root, L, R);
        return result;
    }
    
    private void find(TreeNode root, int l, int r) {
        if (root == null)
            return;
        if (root.val >= l && root.val <= r) {
            result += root.val;
        }
        find(root.left, l, r);
        find(root.right, l, r);
    }
}
