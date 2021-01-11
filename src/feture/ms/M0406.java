package feture.ms;

/**
 * @author lanshan
 */
public class M0406 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int temp = 0;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return find(root, p);
    }

    private TreeNode find(TreeNode root, TreeNode p) {
        if (root == null)
            return null;
        if (root == p) {
            temp = 1;
        }
        TreeNode left = find(root.left, p);
        if (left!=null)
            return left;
        if (temp == 1 && root.val>p.val) {
            return root;
        }
        TreeNode right = find(root.right, p);
        if (right != null)
            return right;
        return null;
    }
}
