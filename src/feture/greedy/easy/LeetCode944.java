package feture.greedy.easy;

/**
 * @author lanshan
 */
public class LeetCode944 {

    public int minDeletionSize(String[] A) {
        int count = 0;
        int length = A[0].length();
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < A.length; j++) {
                if (A[j].charAt(i) - A[j - 1].charAt(i) < 0) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode944 l = new LeetCode944();
        System.out.println(l.minDeletionSize(new String[] {"zyx", "wvu", "tsr"}));
        System.out.println(l.minDeletionSize(new String[] {"a", "b"}));
        System.out.println(l.minDeletionSize(new String[] {"cba", "daf", "ghi"}));
    }
}
