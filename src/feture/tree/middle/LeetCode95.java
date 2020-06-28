package feture.tree.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode95 {
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
        public List<TreeNode> generateTrees(int n) {
            if (n==0) {
                return new ArrayList<>();
            }
            return find(1, n);
        }
        
        private List<TreeNode> find(int start, int end) {
            List<TreeNode> res = new ArrayList<>();
            if (start>end) {
                res.add(null);
                return res;
            }
            for (int i = start; i <= end; i++) {
                List<TreeNode> left = find(start, i - 1);
                List<TreeNode> right = find(i + 1, end);
                for (TreeNode leftNode : left) {
                    for (TreeNode rightNode : right) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftNode;
                        root.right = rightNode;
                        res.add(root);
                    }
                }
            }
            return res;
        }
    }
}
