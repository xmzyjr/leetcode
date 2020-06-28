package feture.tree.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lanshan
 */
public class LeetCode199 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            if (root == null)
                return new ArrayList<>();
            List<Integer> res = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    TreeNode poll = queue.poll();
                    assert poll != null;
                    if (size == 1) {
                        res.add(poll.val);
                    }
                    if (poll.left != null)
                        queue.add(poll.left);
                    if (poll.right != null)
                        queue.add(poll.right);
                    size--;
                }
            }
            return res;
        }
    }
}
