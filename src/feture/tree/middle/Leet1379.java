package feture.tree.middle;

/**
 * @author lanshan
 */
public class Leet1379 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeNode re = null;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        re = null;
        find(cloned, target);
        return re;
    }

    public void find(TreeNode clone, TreeNode target) {
        if (re != null)
            return;
        if (clone == null)
            return;
        if (clone.val == target.val){
            re = clone;
            return;
        }
        find(clone.left, target);
        find(clone.right, target);
    }
}
