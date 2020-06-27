package feture.tree.middle;

import java.util.*;

/**
 * @author lanshan
 */
public class LeetCode508 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        private Map<Integer, Integer> map;
        private int max;
        public int[] findFrequentTreeSum(TreeNode root) {
            if (root == null)
                return new int[0];
            map = new HashMap<>();
            max = 1;
            find(root);
            Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
            List<Integer> result = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : entries) {
                if (entry.getValue().equals(max)) {
                    result.add(entry.getKey());
                }
            }
            return result.stream().mapToInt(i -> i).toArray();
        }
        
        private Integer find(TreeNode root) {
            if (root == null)
                return null;
            Integer left = find(root.left);
            Integer right = find(root.right);
            int result = 0;
            if (left != null)
                result += left;
            if (right != null)
                result += right;
            result += root.val;
            Integer count = map.get(result);
            if (count == null)
                map.put(result, 1);
            else {
                count++;
                max = Math.max(count, max);
                map.put(result, count);
            }
                
            return result;
        }
    }
}
