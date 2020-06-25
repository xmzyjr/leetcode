package feture.tree.middle;

/**
 * @author lanshan
 */
public class LeetCode1008 {
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
        public TreeNode bstFromPreorder(int[] preorder) {
            if (preorder == null || preorder.length == 0)
                return null;
            return find(preorder, 0, preorder.length - 1);
        }
        
        private TreeNode find(int[] preorder, int start, int end) {
            if (end >= preorder.length || start > end) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[start]);
            int leftEnd = start;
            for (int i = start + 1; i <= end; i++) {
                if (preorder[i]>root.val)
                    break;
                leftEnd = i;
            }
            root.left = find(preorder, start+1, leftEnd);
            root.right = find(preorder, leftEnd+1, end);
            return root;
        }
    }
}
