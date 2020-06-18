package feture.tree.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode107 {
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        find(root, 1, result);
        return result;
    }

    /**
     * 如果当前的list 大小，小于目前的层级，需要增加一层，例如：当前遍历到第二层，list的大小还是1
     *
     * 关键在于 result.size() - level，
     * 最下面的层级在list里面的下标肯定是0
     * 那么当前层的下标则是list大小减去当前层（层级从1开始）。（如果从0开始，需要再减1）
     *
     * @param level 层级从1开始
     */
    private void find(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (level > result.size()) {
            result.add(0, new ArrayList<>());
        }
        result.get(result.size() - level).add(root.val);
        find(root.left, level + 1, result);
        find(root.right, level + 1, result);
    }
    
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        LeetCode107 l = new LeetCode107();
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        TreeNode root7 = new TreeNode(7);
        TreeNode root8 = new TreeNode(8);

        root.left = root2;
        root.right = root3;

        root3.left = root4;
        root3.right = root5;

        root4.left = root6;
        root4.right = root7;

        root5.left = root8;

        System.out.println(l.levelOrderBottom(root));
    }
}
