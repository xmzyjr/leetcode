package feture.tree.middle;

/**
 * @author lanshan
 */
public class Offer07 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return find(inorder, preorder, 0, inorder.length-1, 0, preorder.length-1);
        }

        private TreeNode find(int[] mid, int[] post, int start, int end, int start2, int end2) {
            if (start > end || start2 > end2)
                return null;
            if (start == end)
                return new TreeNode(mid[start]);
            TreeNode root = new TreeNode(post[start2]);
            int midIndex = 0;
            for (int i = start; i <= end; i++) {
                if (mid[i] == post[start2]) {
                    midIndex = i;
                    break;
                }
            }
            root.left = find(mid, post, start, midIndex - 1, start2 + 1, midIndex - start + start2);
            root.right = find(mid, post, midIndex + 1, end, midIndex - start + start2 + 1, end2);
            return root;
        }
    }
}
