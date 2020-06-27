package feture.tree.middle;

/**
 * @author lanshan
 */
public class LeetCode889 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            return find(pre, post, 0, pre.length - 1, 0, post.length - 1);
        }

        private TreeNode find(int[] pre, int[] post, int preStart, int preEnd, int postStart, int postEnd) {
            if (preStart > preEnd || postStart > postEnd)
                return null;
            if (preStart == preEnd) {
                return new TreeNode(pre[preStart]);
            }
            TreeNode root = new TreeNode(pre[preStart]);
            int leftPreStartNum = pre[preStart + 1];
            int preRightStartNum = post[postEnd - 1];
            if (leftPreStartNum == preRightStartNum) {
                root.left = find(pre, post, preStart + 1, preEnd, postStart, postEnd - 1);
            } else {
                int preRightStart = 0;
                for (int i = preStart; i <= preEnd; i++) {
                    if (pre[i] == preRightStartNum) {
                        preRightStart = i;
                        break;
                    }
                }

                int postLeftEnd = 0;
                for (int i = postStart; i < postEnd; i++) {
                    if (post[i] == leftPreStartNum) {
                        postLeftEnd = i;
                        break;
                    }
                }
                root.left = find(pre, post, preStart + 1, preRightStart - 1, postStart, postLeftEnd);
                root.right = find(pre, post, preRightStart, preEnd, postLeftEnd + 1, postEnd - 1);
            }
            return root;
        }
    }

}
