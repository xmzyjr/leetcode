package feture.tree.middle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * @author lanshan
 */
public class LeetCode1305 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            List<Integer> list = find(root1);
            List<Integer> list2 = find(root2);
            list.addAll(list2);
            list.sort(Comparator.comparingInt(o -> o));
            return list;
        }
        
        private List<Integer> find(TreeNode root) {
            if (root == null)
                return new ArrayList<>();
            List<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode temp = root;
            while (!stack.isEmpty() || temp != null) {
                if (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                } else {
                    temp = stack.pop();
                    result.add(temp.val);
                    temp = temp.right;
                }
            }
            return result;
        }

    }
}
