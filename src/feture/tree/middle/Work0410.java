package feture.tree.middle;

/**
 * @author lanshan
 */
public class Work0410 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {

        public boolean checkSubTree(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) {
                return true;
            }
            boolean b = find(t1, t2);
            if (t1 != null) {
                boolean left = checkSubTree(t1.left, t2);
                boolean right = checkSubTree(t1.right, t2);
                b = b || left || right;
            }
            return b;
        }
        
        
        private boolean find(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null)
                return true;
            if (t1 == null || t2 == null) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }
            return find(t1.left, t2.left) && find(t1.right, t2.right);
        }
    }
}
