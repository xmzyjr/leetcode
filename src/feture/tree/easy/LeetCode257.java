package feture.tree.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode257 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {

        public List<String> binaryTreePaths(TreeNode root) {
            if (root == null)
                return new ArrayList<>();
            List<String> result = new ArrayList<>();
            find(root, "", result);
            return result;
        }

        private void find(TreeNode root, String way, List<String> result) {
            if (root == null)
                return;
            if (root.left == null && root.right == null) {
                way += root.val;
                result.add(way);
                return;
            }
            String path = way + root.val + "->";
            find(root.left, path, result);
            find(root.right, path, result);
        }

    }
}
