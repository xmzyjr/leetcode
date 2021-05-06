package feture.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lanshan
 */
public class Offer37 {
    /**
     * 请实现两个函数，分别用来序列化和反序列化二叉树。
     *
     * 示例: 
     *
     * 你可以将以下二叉树：
     *
     *     1
     *    / \
     *   2   3
     *      / \
     *     4   5
     *
     * 序列化为 "[1,2,3,null,null,4,5]"
     */

    public static class Codec {
        public class TreeNode {
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

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "[]";
            }
            List<Integer> res = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    res.add(null);
                } else {
                    res.add(poll.val);
                    queue.add(poll.left);
                    queue.add(poll.right);
                }
            }
            int lastIndex = 0;
            for (int i = res.size() - 1; i >= 0; i--) {
                if (res.get(i) != null) {
                    lastIndex = i;
                    break;
                }
            }
            return res.subList(0, lastIndex + 1).toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0 || "[]".equals(data)) {
                return null;
            }
            String substring = data.substring(1, data.length() - 1);
            String[] node = substring.split(",");
            TreeNode[] nodes = new TreeNode[node.length];
            for (int i = 0; i < node.length; i++) {
                if (!"null".equals(node[i]) && !" null".equals(node[i])) {
                    nodes[i] = new TreeNode(Integer.parseInt(node[i].trim()));
                }
            }
            
            int leftIndex = 1, rightIndex = 2;
            int rootIndex = 0;
            while (leftIndex < nodes.length) {
                if (nodes[rootIndex] == null) {
                    rootIndex++;
                    continue;
                }
                nodes[rootIndex].left = leftIndex < node.length ? nodes[leftIndex] : null;
                nodes[rootIndex].right = rightIndex < node.length ? nodes[rightIndex] : null;
                rootIndex++;
                leftIndex += 2;
                rightIndex += 2;
            }
            return nodes[0];
        }
    }

    public static void main(String[] args) {
        Offer37.Codec c = new Codec();
//        System.out.println(c.serialize(c.deserialize("[1,2,3,null,null,4,5]")));
        System.out.println(c.serialize(c.deserialize("[5,2,3,null,null,2,4,3,1]")));
    }
}
