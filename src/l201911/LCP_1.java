package l201911;

/**
 * @author lanshan
 */
public class LCP_1 {
    public int game(int[] guess, int[] answer) {
        if (answer == null || guess == null || answer.length == 0
                || answer.length != guess.length) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == answer[i]) {
                count++;
            }
        }
        return count;
    }
}
