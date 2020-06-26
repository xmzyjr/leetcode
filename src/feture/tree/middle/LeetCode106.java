package feture.tree.middle;

/**
 * @author lanshan
 */
public class LeetCode106 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return find(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
        }
        
        private TreeNode find(int[] mid, int[] post, int start, int end, int start2, int end2) {
            if (start > end || start2 > end2)
                return null;
            if (start == end)
                return new TreeNode(mid[start]);
            TreeNode root = new TreeNode(post[end2]);
            int midIndex=0;
            for (int i = start; i <= end; i++) {
                if (mid[i] == post[end2]) {
                    midIndex = i;
                    break;
                }
            }
            root.left = find(mid, post, start, midIndex - 1, start2, midIndex - 1 - start + start2);
            root.right = find(mid, post, midIndex + 1, end, midIndex - start + start2, end2 - 1);
            return root;
        }
    }
}
