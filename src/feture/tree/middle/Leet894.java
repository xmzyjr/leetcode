package feture.tree.middle;

import java.util.*;

/**
 * @author lanshan
 */
public class Leet894 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        public List<TreeNode> allPossibleFBT(int N) {
            if (map.containsKey(N)) {
                return map.get(N);
            }
            if (N == 1) {
                return Collections.singletonList(new TreeNode(0));
            }
            List<TreeNode> ans = new ArrayList<>();
            for (int i = 1; i < N; i+=2) {
                int y = N - 1 - i;
                for (TreeNode left : allPossibleFBT(i)) {
                    for (TreeNode right: allPossibleFBT(y)) {
                        TreeNode root = new TreeNode(0);
                        root.left = left;
                        root.right = right;
                        ans.add(root);
                    }
                }
            }
            map.put(N, ans);
            return ans;
        }
    }
}
