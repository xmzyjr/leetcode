package feture.offer;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class Offer33 {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0)
            return true;
        int[] mid = Arrays.copyOf(postorder, postorder.length);
        Arrays.sort(mid);
        return find(mid, postorder, 0, mid.length - 1, 0, postorder.length - 1);
    }

    private boolean find(int[] mid, int[] post, int i1, int i2, int j1, int j2) {
        if (i1 > i2 || j1 > j2) {
            return true;
        }
        int root = post[j2];
        int i;
        for (i = i1; i <= i2 ; i++) {
            if (mid[i] == root)
                break;
        }
        if (i > i2) {
            return false;
        }
        return find(mid, post, i1, i - 1, j1, j2 - i2 + i - 1) && find(mid, post, i + 1, i2, j2 - i2 + i, j2 - 1);
    }

    public static void main(String[] args) {
        Offer33 o = new Offer33();
        System.out.println(o.verifyPostorder(new int[] {1, 6, 3, 2, 5}));
        System.out.println(o.verifyPostorder(new int[] { 1, 3, 2, 6, 5 }));
    }
}
