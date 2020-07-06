package feture.binary.search.easy;

/**
 * @author lanshan
 */
public class LeetCode374 {

    abstract class GuessGame {
        abstract int guess(int num);
    }

    public static class Solution {
        public int guessNumber(int n) {
            int left = 1, right = n;
            while (left<=right) {
                int mid = left + (right - left) / 2;
                int guess = guess(mid);
                if (guess == 0) {
                    return mid;
                } else if (guess == 1) {
                    left = mid +1;
                } else if (guess == -1) {
                    right = mid -1;
                }
            }
            return -1;
        }

        int guess(int num) {
            int target = 6;
            return Integer.compare(num, target);
        }

        public static void main(String[] args) {
            LeetCode374.Solution l = new LeetCode374.Solution();
            System.out.println(l.guessNumber(9));
        }
    }
}
