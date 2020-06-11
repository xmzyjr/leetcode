package feture.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode515 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> maxNum = new ArrayList<>();
        find(root, 1, maxNum);
        return maxNum;
    }
    
    private void find(TreeNode root, int level, List<Integer> maxResult) {
        if (root == null)
            return;
        if (level > maxResult.size())
            maxResult.add(Integer.MIN_VALUE);
        if (root.val > maxResult.get(level - 1)) {
            maxResult.set(level - 1, root.val);
        }
        find(root.left, level+1, maxResult);
        find(root.right, level+1, maxResult);
    }

}
