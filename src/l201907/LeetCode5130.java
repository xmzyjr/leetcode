
package l201907;

/**
 * @author lanshan
 */
public class LeetCode5130 {

    public int numEquivDominoPairs(int[][] dominoes) {
        if (dominoes == null || dominoes.length < 2) {
            return 0;
        }
        int[] hash = new int[dominoes.length];
        int sum = 0;
        for (int i = dominoes.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < dominoes.length; j++) {
                boolean check1 = dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1];
                boolean check2 = dominoes[i][0] == dominoes[j][1] && dominoes[i][1] == dominoes[j][0];
                if (check1 || check2) {
                    hash[i] = hash[j] + 1;
                    sum += hash[i];
                    break;
                }
            }
        }
        return sum;

    }

    public static void main(String[] args) {
        LeetCode5130 l = new LeetCode5130();
        l.numEquivDominoPairs(new int[][]{{1,2},{1,2},{1,1},{1,2},{2,2}});
    }
}
