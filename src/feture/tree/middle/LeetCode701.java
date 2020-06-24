package feture.tree.middle;

/**
 * @author lanshan
 */
public class LeetCode701 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null)
                return new TreeNode(val);
            TreeNode temp = root;
            TreeNode temp1;
            while (true) {
                if (temp.val>val) {
                    temp1 = temp;
                    temp = temp.left;
                    if (temp == null) {
                        temp1.left = new TreeNode(val);
                        break;
                    }
                } else if (temp.val<val) {
                    temp1 = temp;
                    temp = temp.right;
                    if (temp == null) {
                        temp1.right = new TreeNode(val);
                        break;
                    }
                }
            }
            return root;
        }
    }
}
