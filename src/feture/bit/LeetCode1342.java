package feture.bit;

/**
 * @author lanshan
 */
public class LeetCode1342 {
    static class Solution {
        public int numberOfSteps (int num) {
            if (num <= 0) {
                return 0;
            }
            int count = 0;
            while (num > 0) {
                if ((num & 1) == 0) {
                    num = num / 2;
                } else {
                    num--;
                }
                count++;
            }
            return count;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.numberOfSteps(3));
        }
    }
}
