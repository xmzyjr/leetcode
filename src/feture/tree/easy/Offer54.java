package feture.tree.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lanshan
 */
public class Offer54 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {

        public int kthLargest(TreeNode root, int k) {
            if (root == null || k == 0)
                return 0;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode temp = root;
            List<Integer> result = new ArrayList<>();
            while (!stack.isEmpty() || temp != null) {
                if (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                } else {
                    temp = stack.pop();
                    result.add(temp.val);
                    temp = temp.right;
                }
            }
            if (k > result.size()) {
                return 0;
            }
            return result.get(result.size() - k);
        }
    }
}
