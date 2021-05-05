package feture.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class Offer34 {
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

    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList<>();
        find(root, target, 0, new ArrayList<>());
        return res;
    }

    private void find(TreeNode root, int target, int sum, List<Integer> temp) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (target == sum + root.val) {
                temp.add(root.val);
                res.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
            }
            return;
        }
        temp.add(root.val);
        find(root.left, target, sum + root.val, temp);
        find(root.right, target, sum + root.val, temp);
        temp.remove(temp.size() - 1);
    }
}
