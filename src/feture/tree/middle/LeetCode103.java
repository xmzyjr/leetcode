package feture.tree.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode103 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        find(root, 1, result);
        return result;
    }
    
    private void find(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null)
            return;
        if (level > result.size())
            result.add(new ArrayList<>());
        if (level % 2 == 0) {
            result.get(level - 1).add(0, root.val);
        } else {
            result.get(level - 1).add(root.val);
        }
        find(root.left, level + 1, result);
        find(root.right, level + 1, result);
    }
}
