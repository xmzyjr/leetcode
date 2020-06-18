package feture.tree.middle;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lanshan
 */
public class Work0412 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

    int result = 0;
    Set<TreeNode> set;
    public int pathSum(TreeNode root, int sum) {
        set = new HashSet<>();
        result = 0;
        if (root == null)
            return result;
        find(root, null, sum);
        return result;
    }

    private void find(TreeNode root, Integer sum, int target) {
        Integer temp = sum;
        if (root == null || (set.contains(root) && sum== null))
            return;
        if (sum == null)
            sum = 0;
        int now = sum + root.val;
        if (now == target)
            result++;
        find(root.left, now, target);
        find(root.right, now, target);
        find(root.left, null, target);
        find(root.right, null, target);
        if (temp == null)
            set.add(root);
    }


    public static void main(String[] args) {
        Work0412 work0412 = new Work0412();
        TreeNode node1 = new TreeNode(-2);
        TreeNode node2 = new TreeNode(-3);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.right = node2;


        System.out.println(work0412.pathSum(node1, -3));
    }
}
