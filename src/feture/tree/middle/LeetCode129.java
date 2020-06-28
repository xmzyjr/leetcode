package feture.tree.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode129 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public int sumNumbers(TreeNode root) {
            if (root == null)
                return 0;
            List<Integer> res = new ArrayList<>();
            find(root, res, "");
            int sum = 0;
            for (Integer re : res) {
                sum += re;
            }
            return sum;
        }
        
        private void find(TreeNode root, List<Integer> result, String num) {
            if (root.left == null && root.right == null) {
                result.add(Integer.valueOf(num + root.val));
                return;
            }
            String newNum = num + root.val;
            if (root.left!=null)
            find(root.left, result, newNum);
            if (root.right!=null)
            find(root.right, result, newNum);
        }
    }
}
