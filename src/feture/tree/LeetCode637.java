package feture.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode637 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        find(root, 1, result);
        if (result.size() == 0) {
            return new ArrayList<>();
        }
        List<Double> aveResult = new ArrayList<>();
        for (List<Integer> integers : result) {
            long sum = 0;
            for (Integer integer : integers) {
                sum += integer;
            }
            aveResult.add(sum*1.0/integers.size());
        }
        return aveResult;
    }
    
    private void find(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (level > result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(level - 1).add(root.val);
        find(root.left, level + 1, result);
        find(root.right, level + 1, result);
    }
    
    
}
