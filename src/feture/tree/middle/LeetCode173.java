package feture.tree.middle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lanshan
 */
public class LeetCode173 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class BSTIterator {

        private final List<Integer> temp;
        int index = 0;
        public BSTIterator(TreeNode root) {
            temp = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode tp = root;
            while (!stack.isEmpty() || tp!=null) {
                if (tp!=null) {
                    stack.push(tp);
                    tp = tp.left;
                } else {
                    tp = stack.pop();
                    temp.add(tp.val);
                    tp = tp.right;
                }
            }
        }

        /** @return the next smallest number */
        public int next() {
            return temp.get(index++);
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return index != temp.size();
        }
    }
}
