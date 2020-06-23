package feture.tree.easy;

/**
 * @author lanshan
 */
public class Offer68I {
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
            int pNum = p.val;
            int qNum = q.val;
            if (pNum>qNum) {
                int temp = pNum;
                pNum = qNum;
                qNum = temp;
            }
            TreeNode result = null;
            TreeNode temp = root;
            while (result == null) {
                if (temp.val>=pNum && temp.val<=qNum) {
                    result = temp;
                }
                if (temp.val>qNum) {
                    temp = temp.left;
                    continue;
                }
                temp = temp.right;
            }
            return result;
        }
    }
}
