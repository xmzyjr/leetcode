
package l201907;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lanshan
 */
public class LeetCode5119 {

    private static class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<TreeNode> queue1 = new ArrayDeque<>();
        List<TreeNode> heads = new ArrayList<>();
        List<TreeNode> result = new ArrayList<>();
        TreeNode nullNode = new TreeNode(0);
        heads.add(root);
        for (int i = 0; i < heads.size(); i++) {
            queue.add(heads.get(i));
            TreeNode temp = new TreeNode(heads.get(i).val);
            queue1.add(temp);
            result.add(temp);
            while (queue.size() > 0) {
                TreeNode root1 = queue.poll();
                TreeNode root2 = queue1.poll();
                if (root1 == nullNode)
                    continue;
                temp = root2;
                if (root1.left != null) {
                    if (!set.contains(root1.left.val)) {
                        temp.left = new TreeNode(root1.left.val);
                        queue1.add(temp.left);
                        queue.add(root1.left);
                    } else {
                        queue.add(nullNode);
                        if (root1.left.left != null) {
                            heads.add(root1.left.left);
                        }
                        if (root1.left.right != null) {
                            heads.add(root1.left.right);
                        }
                    }
                }
                if (root1.right != null) {
                    if (!set.contains(root1.right.val)) {
                        temp.right = new TreeNode(root1.right.val);
                        queue1.add(temp.right);
                        queue.add(root1.right);
                    } else {
                        queue.add(nullNode);
                        if (root1.right.left != null) {
                            heads.add(root1.right.left);
                        }
                        if (root1.right.right != null) {
                            heads.add(root1.right.right);
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * 输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
     * 输出：[[1,2,null,4],[6],[7]]
     */
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;

        t2.left = t4;
        t2.right = t5;

        t3.left = t6;
        t3.right = t7;

        LeetCode5119 l = new LeetCode5119();
        l.delNodes(t1, new int[]{3,5});
    }
}
