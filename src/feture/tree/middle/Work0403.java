package feture.tree.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class Work0403 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null)
            return null;
        List<ListNode> result = new ArrayList<>();
        find(tree, 1, result);
        return result.toArray(new ListNode[0]);
    }
    
    private void find(TreeNode root, int level, List<ListNode> result) {
        if (root == null)
            return;
        if (level > result.size()) {
            ListNode temp = new ListNode(root.val);
            result.add(temp);
        } else {
            ListNode listNode = result.get(level - 1);
            while (listNode.next!=null) {
                listNode = listNode.next;
            }
            listNode.next = new ListNode(root.val);
        }
        find(root.left, level + 1, result);
        find(root.right, level + 1, result);
    }
}
