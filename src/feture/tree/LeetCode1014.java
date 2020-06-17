package feture.tree;

/**
 * @author lanshan
 */
public class LeetCode1014 {

    public int maxScoreSightseeingPair(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i+1; j < A.length; j++) {
                int sum = A[i] + A[j] + i - j;
                max = Math.max(sum, max);
            }
        }
        return max;
    }
    
    public int find(int[] A) {
        int max = A[0];
        int ans = 0;
        for (int i = 1; i < A.length; i++) {
            ans = Math.max(ans, max + A[i] - i);
            max = Math.max(max, A[i] + i);
        }
        return ans;
    }
}
