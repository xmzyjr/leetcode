package feture.tree.hard;

/**
 * @author lanshan
 */
public class LeetCode1028 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int index = 0;
    public TreeNode recoverFromPreorder(String S) {
        if (S == null || S.length() == 0)
            return null;
        TreeNode root = node(S);
        find(root, S, 1);
        return root;
    }
    
    private int find(TreeNode root, String s, int level) {
        if (index == s.length()) {
            return 0;
        }
        int count = 0;
        while (s.charAt(index) == '-') {
            count++;
            index++;
        }
        if (count < level) {
            return count;
        }
        root.left = node(s);
        count = find(root.left, s, level + 1);
        if (count < level)
            return count;
        root.right = node(s);
        count = find(root.right, s, level + 1);
        return count;
    }
    
    private TreeNode node(String s) {
        int start = index;
        while (index != s.length() && s.charAt(index) != '-') {
            index++;
        }
        String left = s.substring(start, index);
        return new TreeNode(Integer.parseInt(left));
    }

    public static void main(String[] args) {
        LeetCode1028 l = new LeetCode1028();
        System.out.println(l.recoverFromPreorder("1-2--3--4-5--6--7"));
    }
}
