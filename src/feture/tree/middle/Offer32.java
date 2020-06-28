package feture.tree.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lanshan
 */
public class Offer32 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public int[] levelOrder(TreeNode root) {
            if (root == null)
                return new int[0];
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            ArrayList<Integer> result = new ArrayList<>();
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    TreeNode poll = queue.poll();
                    assert poll != null;
                    result.add(poll.val);
                    if (poll.left!=null)
                        queue.add(poll.left);
                    if (poll.right!=null)
                        queue.add(poll.right);
                }
            }
            int[] res = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                res[i] = result.get(i);
            }
            return res;
        }
    }
}
