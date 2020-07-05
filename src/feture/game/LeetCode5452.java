package feture.game;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class LeetCode5452 {
    class Solution {

        public boolean canMakeArithmeticProgression(int[] arr) {
            if (arr == null || arr.length == 0)
                return false;
            Arrays.sort(arr);
            int check = arr[1] - arr[0];
            for (int i = 2; i < arr.length; i++) {
                if (arr[i] - arr[i - 1] != check) {
                    return false;
                }
            }
            return true;
        }
    }
}
