package feture.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class Offer32_3 {

    public class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        res = new ArrayList<>();
        find(root, 1);
        return res;
    }

    private void find(TreeNode root, int index) {
        if (root == null)
            return;
        if (index > res.size()) {
            res.add(new ArrayList<>());
        }
        List<Integer> list = res.get(index - 1);
        if (index % 2 == 0) {
            list.add(0, root.val);
        } else {
            list.add(root.val);
        }
        find(root.left, index + 1);
        find(root.right, index + 1);
    }
}
