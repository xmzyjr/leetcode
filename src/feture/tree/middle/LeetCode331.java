package feture.tree.middle;

/**
 * @author lanshan
 */
public class LeetCode331 {

    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return false;
        }
        if (preorder.length() == 1 && preorder.endsWith("#")) {
            return true;
        }
        String[] treeNode = preorder.split(",");
        if (treeNode.length <= 2) {
            return false;
        }
        int finalIndex = 0;
        try {
            finalIndex = find(treeNode, 0);
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return finalIndex + 1 == treeNode.length;
    }

    private int find(String[] treeNode, int recursiveIndex) {
        if (treeNode[recursiveIndex].endsWith("#")) {
            return recursiveIndex;
        }
        int leftIndex = find(treeNode, recursiveIndex + 1);
        return find(treeNode, leftIndex + 1);
    }
}
