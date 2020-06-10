package feture.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> re = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.left == null && root.right == null) {
            List<Integer> result = new ArrayList<>();
            result.add(root.val);
            re.add(result);
            return re;
        }
        List<TreeNode> treeNodeList = new ArrayList<>();
        int start=0, end = 0;
        treeNodeList.add(root);
        end = 1;
        while (start!=end) {
            List<Integer> temp = new ArrayList<>();
            for (int i = start; i < end; i++) {
                TreeNode treeNode = treeNodeList.get(i);
                temp.add(treeNode.val);
                if (treeNode.left != null) {
                    treeNodeList.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    treeNodeList.add(treeNode.right);
                }
            }
            start = end;
            end = treeNodeList.size();
            re.add(temp);
        }
        return re;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        find(root, 1, result);
        return result;
    }

    private void find(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (level > result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(level-1).add(root.val);
        find(root.left, level + 1, result);
        find(root.right, level+1, result);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
