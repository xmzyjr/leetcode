package feture.game;

/**
 * @author lanshan
 */
public class LeetCode5453 {
    static class Solution {
        public int getLastMoment(int n, int[] left, int[] right) {
            if (left.length==0 && right.length == 0) {
                return 0;
            }
            if (left.length == 0)
                return find(n, right, false);
            if (right.length == 0)
                return find(n, left, true);
            return Math.max(find(n,left, true), find(n,right,false));
        }

        private int find(int n, int[] num, boolean isLeft) {
            int max = isLeft ? num[0] : n - num[0];
            for (int i = 1; i < num.length; i++) {
                if (isLeft) {
                    max = Math.max(max, num[i]);
                } else {
                    max = Math.max(max, n-num[i]);
                }
            }
            return max;
        }


        public static void main(String[] args) {
            LeetCode5453.Solution l = new LeetCode5453.Solution();
            l.getLastMoment(7, new int[0], new int[]{0,1,2,3,4,5,6,7});
        }
    }
}
